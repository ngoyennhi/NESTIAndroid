package com.example.nesti_mes_recettes;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.entity.Recipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SaisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saison);

        // tableau des recettes seasons
        ArrayList<Recipe> seasonal_recipes = readJSONRecipe("season.json");
        Log.i("LogNesti","Tableau recu " + seasonal_recipes.size());
        // season_listView = nom de "layout" liste
        ListView list_View = findViewById((R.id.season_listView));
        // utilise notre propre "addapter" pour affichier les recipes
        RecipeAdapter adapter = new RecipeAdapter(this, R.layout.line_recipe,seasonal_recipes);
        list_View.setAdapter(adapter);
    }
    /*
    Pour gérer ces données, on utilisera la classe Recipe.
    Les données JSON vont être récupérées dans un JSONArray.
    Ensuite chaque élément du tableau JSONArray sera traité en tant que JSONObject.
     */
    private String readJson(String pFileJsonName){
        // Traitement du Json
        // Initialisation
        StringBuilder builder = new StringBuilder();
        AssetManager asset_manager = this.getAssets();
        InputStreamReader isr;
        BufferedReader data;

        try{
            isr = new InputStreamReader(asset_manager.open(pFileJsonName));
            data = new BufferedReader(isr);
            String line;
            while ((line = data.readLine()) != null){
                builder.append(line);
            }
        }
        catch (IOException e){
            Log.e("LogNesti","Erreur de lecture du Json");
            e.printStackTrace();
        }
        return builder.toString();
    }

    /*
    Ajouter une méthode qui, à partir d’une chaîne de caractère JSON,
    donne un tableau d’objet de type Recipe.
     */
    private ArrayList<Recipe> readJSONRecipe(String pFileJsonName) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        String stringJSON = this.readJson(pFileJsonName);

        try{
            //classe JSON Array pour passer les données du fichier JSON
            //note: il est impératif de stocker le fichier season.json dans ASSETS
            JSONArray tableau_JSON = new JSONArray(stringJSON);
            Log.i("LogNesti","Nombre denregistrements : " + tableau_JSON.length());
            //Parcours du tableau
            for(int i = 0;i<tableau_JSON.length(); i++){
                JSONObject object_JSON = tableau_JSON.getJSONObject(i);
                //Une fois les données JSON du fichier seazon.json récupérées dans le tableau JSONArray,
                // il suffira de parcourir ce tableau et d’extraire les informations concernant chacune des recettes de la catégorie seazon,
                // grâce à la classe JSONObject.
                Recipe r = new Recipe();
                // chaque lot d'info sera stocké dans un objet Recipe
                r.setCat(object_JSON.getString("cat"));
                r.setTitle(object_JSON.getString("title"));
                r.setAuthor(object_JSON.getString("author"));
                int index = this.getResourceImage(object_JSON.getString("img"));
                r.setImgId(index);
                r.setDifficulty(object_JSON.getInt("diff"));
                // A completer
                recipes.add(r);
            }
        }
        catch (Exception e){
            Log.e("LogNesti","Erreur de lecture du Json");
            e.printStackTrace();
        }
        return recipes;
    }
    /*
     //Retourne l'identifiant d'une image
     @param nameImage
    @return
    */
    private int getResourceImage(String nameImage){
        String path = getPackageName()+ ":drawable/" + nameImage;
        return getResources().getIdentifier(path,null,null);
    }
}


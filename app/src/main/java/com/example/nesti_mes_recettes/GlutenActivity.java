package com.example.nesti_mes_recettes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.entity.Recipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GlutenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gluten);

        //API recipes sans gluten
        requestApi();

    }

    private void requestApi(){
        //l’url qui sera interrogée
        //Récupérez l’url du end-point qui fournis les recettes de la catégories “Sans gluten”
        // localhost
        String url = "http://localhost:8888/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/category/sansgluten";

       // // server
       // //Remplacer les pointillés par le nom du projet Codeigniter.
       // //Remplacer les ... par votre chemin. (normalement c’est le nom du projet)
       // //Important : Remplacer “127.0.0.1” par votre adresse ip
       // String url = "http://192.168.1.65/www/.../public/index.php/api/category/gluten"

       final RequestQueue request_queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest array_request = new JsonArrayRequest(
                url,
                //Une interface de rappel (Callback Interface) pour fournir des réponses analysées
                new Response.Listener<JSONArray>(){
                         @Override
                         public void onResponse(JSONArray response){
                            //Traitement de la réponse
                            // ArrayList<Recipe> sansGluten_recipes = readJSONRecipe(response);
                            // Log.i("LogNesti",response.toString());
                             // season_listView = nom de "layout" liste
                             //ListView list_View = findViewById((R.id.sansGluten_listView));
                             // utilise notre propre "addapter" pour affichier les recipes
                            // RecipeAdapter adapter = new RecipeAdapter(this, R.layout.line_recipe,sansGluten_recipes);
                            // list_View.setAdapter(adapter);
                         }
                    },
                //Interface de rappel pour fournir des réponses d'erreur.
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // En cas d'eurrer
                        Toast.makeText(getApplicationContext(),"Une erreur est survenue sur l'interrogation de l'API",
                        Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );
        request_queue.add(array_request);
        Log.i("LogNesti",request_queue.toString());
    }

    /*
    Ajouter une méthode qui, à partir d’une chaîne de caractère JSON,
    donne un tableau d’objet de type Recipe.
     */
    private ArrayList<Recipe> readJSONRecipe(JSONArray response) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try{
            //classe JSON Array pour passer les données du fichier JSON
            //note: il est impératif de stocker le fichier season.json dans ASSETS
            JSONArray tableau_JSON = response;
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
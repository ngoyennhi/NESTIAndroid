package com.example.nesti_mes_recettes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.adapter.RecipeAdapterDetail;
import com.example.nesti_mes_recettes.entity.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TabRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_recipe_detail);
        // Réception des données
        //Bundle extras = getIntent().getExtras();
        // on extrait chaque données de extras
        Intent intent = getIntent();
        //int id = extras.getInt("id");
        int id = intent.getIntExtra("id",0);
        //String nom_de_la_recette = extras.getString("id");
       // Log.i("LogNesti","onResponse: "+ id );

        // continue le code avec les informations pour afficher continue
         requestApi(this, id);
    }

    private void requestApi(TabRecipeActivity TabRecipeActivity,int id){
        //l’url qui sera interrogée
        //Récupérez l’url du end-point qui fournis les recettes de la catégories “Sans gluten”
        //Important : Remplacer “XX.XXX.XX.XX” par ip mac connexion wifi
        //Remplacer les pointillés par le nom du projet Codeigniter.
        // Remplacer les ... par votre chemin. (normalement c’est le nom du projet)

        //String url = "http://XX.XXX.XX.XX:8888/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/category/sansgluten";

        String url = "http://XX.XXX.XX.XX:8888/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/searchId/"+id;

        //String url = "https://hotongminh.needemand.com/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/category/sansgluten";

        final RequestQueue request_queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest array_request = new JsonArrayRequest(
                url,
                //Une interface de rappel (Callback Interface) pour fournir des réponses analysées
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response){
                        //Traitement de la réponse
                      // Log.i("TAG", "onResponse: "+response);

                        ArrayList<Recipe> recipe_detail = readJSONRecipe(response.toString());
                        Log.i("TAG", "onResponse: "+recipe_detail);
                        ListView list_view = (ListView) findViewById(R.id.Tab_listview_detail);
                        RecipeAdapter adapter = new RecipeAdapter(getApplicationContext(), R.layout.line_recipe_detail, recipe_detail);
                        list_view.setAdapter(adapter);

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
        //Log.i("TAG", "onResponse: "+ request_queue);
    }
    /*
   Ajouter une méthode qui, à partir d’une chaîne de caractère JSON,
   donne un tableau d’objet de type Recipe.
    */
    private ArrayList<Recipe> readJSONRecipe(String response) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try{
            JSONArray tableau_JSON = new JSONArray(response);
            //classe JSON Array pour passer les données du fichier JSON
            //note: il est impératif de stocker le fichier season.json dans ASSETS

            //Log.i("LogNesti","Nombre denregistrements : " + tableau_JSON.length());
            //Parcours du tableau
            //Log.i("LogNesti", "readJSONRecipe: " + response);
            for(int i = 0;i<tableau_JSON.length(); i++){
                JSONObject object_JSON = tableau_JSON.getJSONObject(i);
                //Une fois les données JSON du fichier seazon.json récupérées dans le tableau JSONArray,
                // il suffira de parcourir ce tableau et d’extraire les informations concernant chacune des recettes de la catégorie seazon,
                // grâce à la classe JSONObject.
                Recipe r = new Recipe();
                // chaque lot d'info sera stocké dans un objet Recipe
                r.setId(object_JSON.getInt("Id"));
                r.setTitle(object_JSON.getString("nom_de_la_recette"));
                r.setAuthor(object_JSON.getString("nom"));
                r.setCat(object_JSON.getString("cat"));
                r.setTemps(object_JSON.getInt("temps"));
                r.setNombrePersonne(object_JSON.getInt("nombre_de_personne"));
                int index = this.getResourceImage(object_JSON.getString("nom_img"));
                r.setImgId(index);
                int iddiff = object_JSON.getInt("difficulte");
                String imageDiff = difficultImageConverter(iddiff);
                int iStar = this.getResourceImage(imageDiff);
                r.setImgIdStar(iStar);

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
    public int getResourceImage(String nameImage){
        String path = getPackageName()+ ":drawable/" + nameImage;
        return getResources().getIdentifier(path,null,null);
    }

   public String difficultImageConverter(int diff) {
        String img_name = new String();
        if (diff == 1) {
            img_name = "star_1";
            Log.i("img_name", img_name);
        } else if (diff == 2) {
            img_name = "star_2";
            Log.i("img_name", img_name);
        } else if (diff == 3) {
            img_name = "star_3";
            Log.i("img_name", img_name);
        } else if (diff == 4) {
            img_name = "star_4";
            Log.i("img_name", img_name);
        } else if (diff == 5) {
            img_name = "star_5";
            Log.i("img_name", img_name);
        }
        return img_name;
    }
}

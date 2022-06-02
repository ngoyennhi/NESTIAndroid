package com.example.nesti_mes_recettes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.adapter.RecipeAdapterSearch;
import com.example.nesti_mes_recettes.entity.Recipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // réception du terme à rechercher
        //getIntent() permet de récupérer l’intent qui vient d’arriver.
        //getStringExtra(“term”) permet de récupérer la valeur de saisie.
        String term = this.getIntent().getStringExtra("term");
        // Modification du textView
        TextView text_view = findViewById(R.id.result_txtview_term);
        // set text subtitle à partir de la valuer term.
        text_view.setText(term);

        requestApi(this,term);

    }

    private void requestApi(ResultActivity resultActivity, String term){
        //l’url qui sera interrogée
        //Récupérez l’url du end-point qui fournis les recettes de la catégories “Sans gluten”
        //Important : Remplacer “XX.XXX.XX.XX” par ip mac connexion wifi
        //Remplacer les pointillés par le nom du projet Codeigniter.
        // Remplacer les ... par votre chemin. (normalement c’est le nom du projet)

        //String url = "http://XX.XXX.XX.XX:8888/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/search/Macarons";

        String url = "http://XX.XXX.XX.XX:8888/nestiADMIN_CodeIgniter4/project_root_CodeIgniter4/public/index.php/api/search/"+term;

        final RequestQueue request_queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest array_request = new JsonArrayRequest(
                url,
                //Une interface de rappel (Callback Interface) pour fournir des réponses analysées
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response){
                        //Traitement de la réponse
                        Log.i("TAG", "onResponse: "+response);
                        ArrayList<Recipe> search_activity = readJSONRecipe(response.toString());
                        ListView list_view = (ListView) findViewById(R.id.result_listView);
                        RecipeAdapterSearch adapter = new RecipeAdapterSearch(getApplicationContext(), R.layout.line_recipe_search, search_activity);
                        list_view.setAdapter(adapter);
                        //Log.i("LogNesti",response.toString());
                        // Evenemment sur chaque bouton voir
                      //  final Button btnVoir =(Button)findViewById(R.id.search_btn_voir);
                       // btnVoir.setOnClickListener(new View.OnClickListener() {
                         //   @Override
                         //  public void onClick(View v)
                         // {
                             //  // Displaying simple Toast message
                            //  Toast.makeText(getApplicationContext(),
                                     //    "TOTO",
                                     //    Toast.LENGTH_LONG)
                                   //.show();
                          //  }
                     // });

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

            Log.i("LogNesti","Nombre denregistrements : " + tableau_JSON.length());
            //Parcours du tableau
            Log.i("LogNesti", "readJSONRecipe: " + response);
            for(int i = 0;i<tableau_JSON.length(); i++){
                JSONObject object_JSON = tableau_JSON.getJSONObject(i);
                //Une fois les données JSON du fichier seazon.json récupérées dans le tableau JSONArray,
                // il suffira de parcourir ce tableau et d’extraire les informations concernant chacune des recettes de la catégorie seazon,
                // grâce à la classe JSONObject.
                Recipe r = new Recipe();
                // chaque lot d'info sera stocké dans un objet Recipe
                r.setId(object_JSON.getInt("Id"));
                r.setTitle(object_JSON.getString("nom_de_la_recette"));
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

}

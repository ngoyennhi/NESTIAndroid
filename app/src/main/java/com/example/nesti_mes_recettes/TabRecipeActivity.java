package com.example.nesti_mes_recettes;

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
import com.example.nesti_mes_recettes.entity.Recipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TabRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_recipe);
        // Réception des données
        Bundle extras = getIntent().getExtras();
        // on extrait chaque données de extras
        int id = extras.getInt("id");
        //String nom_de_la_recette = extras.getString("nom_de_la_recette");
        Log.i("Log","onResponse: "+ id );

    }
}

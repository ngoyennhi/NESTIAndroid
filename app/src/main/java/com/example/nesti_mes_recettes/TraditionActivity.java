package com.example.nesti_mes_recettes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nesti_mes_recettes.entity.Recipe;

import java.util.ArrayList;

public class TraditionActivity<adapter> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradition);
        //tableau des recettes traditionnelles
        ArrayList <Recipe> traditional_recipes = new ArrayList<Recipe>();

        Recipe r1 = new Recipe();
        r1.setCat("Tradition");
        r1.setTitle("Macarons");
        r1.setAuthor("Cédric Grolet");

        traditional_recipes.add(r1);

        Recipe r2 = new Recipe();
        r2.setCat("Tradition");
        r2.setTitle("Eclair au chocolat");
        r2.setAuthor("Philipe Conticini");

        traditional_recipes.add(r2);

    /*
// List View
 */
        // on attrape le composant pour récuper l'élement Listview du layout par son identifiant
        ListView list_View = findViewById(R.id.tradition_listview);
        // on crée un adaptateur pour faire le lien entre les données et la listView
        // une simple liste d'éléments et alimentée par le tableau de recettes this.eastRecipes
        // deuxieme param détermine l'affichage de chaque élément de la liste
        ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(this,android.R.layout.simple_list_item_1,traditional_recipes);
        // on relie les deux
        list_View.setAdapter(adapter);

    }
}


package com.example.nesti_mes_recettes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PresentationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        /*
        // List View
         */
        // on attrape le composant pour récuper l'élement Listview du layout par son identifiant
        ListView listView = findViewById(R.id.Tab_listview_detail);
        // on crée un adaptateur pour faire le lien entre les données et la listView
        // une simple liste d'éléments et alimentée par le tableau de recettes this.eastRecipes
        // deuxieme param détermine l'affichage de chaque élément de la liste
        // par default on utilise ArrayAdapter si l'on n'a pas encore notre appdater :) 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.aboutNesti);
        // on relie les deux
        listView.setAdapter(adapter);

    }

    public String[] aboutNesti ={
            "ABOUT NESTI",
            "Fondé en 1984 par les Frères Hernandez, notre établissement a fourni un excelent chocolat venant des quatres coins du monde. C'est en 1945, que Marina Hernadez, decide de diversifier l'entreprise familiale, sans perdre en prestige. ",
            "Nesti devint alors une référence dans le monde de la patisserie" ,
             "Nous consacrons notre temps à trouver les meilleurs ingrédients à travers le monde",
    };



}
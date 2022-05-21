package com.example.nesti_mes_recettes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EasyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        /*
        // List View
         */
        // on attrape le composant pour récuper l'élement Listview du layout par son identifiant
        ListView listView = findViewById(R.id.tradition_listview);
        // on crée un adaptateur pour faire le lien entre les données et la listView
        // une simple liste d'éléments et alimentée par le tableau de recettes this.eastRecipes
        // deuxieme param détermine l'affichage de chaque élément de la liste
        // par default on utilise ArrayAdapter si l'on n'a pas encore notre appdater :) 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,this.easyRecipes);
        // on relie les deux
        listView.setAdapter(adapter);
        // Evenemment sur chaque élément
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "Position:" +String.valueOf(position)+" ,Rec:" +easyRecipes[position],
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );
    }

    public String[] easyRecipes ={
            "Gateau au yaourt",
            "Crèpes",
            "Muffins",
            "Cookies"
    };



}
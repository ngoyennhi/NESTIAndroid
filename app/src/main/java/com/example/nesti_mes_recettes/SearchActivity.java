package com.example.nesti_mes_recettes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;

import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    /**
     * Interagir avec un Listener
     * findViewById pour accéeder à un bouton
     * un Listener permet de récupérer l'évenement d'interaction avec le bouton

     */

    //Au démarrage de l’activité, on associe ce layout grâce à la méthode setContentView :
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_search);

        //Au départ de l’intent,
        EditText edit_text = findViewById(R.id.search_editTxt_recipe);
        final Button btn_ok = findViewById(R.id.search_btn_ok);

        /*
         // Gestion du bouton btnRecherche
        */
        // Utilisation d'un écouteur d'évenement pour récupérer l'intéraction avec le bouton
        btn_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Récupération de la valeur saisie
                String term = edit_text.getText().toString();
                Intent intent = new Intent(SearchActivity.this, ResultActivity.class);
                // Ajout de l’extra “term”
                intent.putExtra("term", term);
                startActivity(intent);
            } });

    }
}
package com.example.nesti_mes_recettes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;

import android.util.Log;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

/**
 * Gestion ouverture/fermeture du menu général
 * @param pMenu Menu
 * @return boolean true
 * La classe MenuInflater gère l'ouverture du mode "menu" de l'application par le téléphone
 */
@Override
   public boolean onCreateOptionsMenu(Menu pMenu) {
    MenuInflater inflater = this.getMenuInflater();
    inflater.inflate(R.menu.menu_general, pMenu);
    return true;
}

/**
 * Lance une action en fonction de l'élément du menu selectionné
 * @param pItem MenuItem
 * @return
 * Log.i: Affiche le message en mode"info"
 */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem pItem){
    switch (pItem.getItemId()){
        case R.id.menu_search:
            Log.i("LogNesti","Menu : Recherche");
            //Vers l’activité Recherche ( SearchActivity )
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);
            //Toast
            Toast.makeText(this, "Menu : Recherche", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_liste:
            //Log.i("LogNesti","Menu : Liste de course");
            //Toast
            Toast.makeText(this, "Menu : Liste de course", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_present:
            //Log.i("LogNesti","Menu : Presentation");
            //Toast
            Toast.makeText(this, "Menu : Présentation", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_contact:
            //Log.i("LogNesti","Menu : Contact");
            //Toast
            Toast.makeText(this, "Menu : Contact", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_projet:
            //Log.i("LogNesti","Menu : Project");
            //Toast
            Toast.makeText(this, "Menu : Project", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_team:
            //Log.i("LogNesti","Menu : Team");
            //Toast
            Toast.makeText(this, "Menu : Team", Toast.LENGTH_SHORT).show();
            break;
       }
     return false;
   }

   /**
 * Interagir avec un Listener
 * findViewById pour accéeder à un bouton
 * un Listener permet de récupérer l'évenement d'interaction avec le bouton
 * + un clic à l'apparition d'un message de type Toast
  */

   //Au démarrage de l’activité, on associe ce layout grâce à la méthode setContentView :
    @Override
    protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_main);
        // Les boutons
        final Button btnEasy =(Button)findViewById(R.id.main_btn_easy);
        final Button btnTrade =(Button)findViewById(R.id.main_btn_traditionel);
        final Button btnSaison =(Button)findViewById(R.id.main_btn_season);
        final Button btnGlu =(Button)findViewById(R.id.main_btn_gluten);

        /*
         // Gestion du bouton btnEasy associé à la ressource ButtonMainEasy
        */
        // Utilisation d'un écouteur d'évenement pour récupérer l'intéraction avec le bouton
        btnEasy.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Demande confirmation avec action
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Facile à faire");
                alertDialog.setMessage("Voulez vous choisir une recette facile à faire?");
                //confirmation oui
                alertDialog.setPositiveButton("oui",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), btnEasy.getText(), Toast.LENGTH_SHORT).show();
                        //Lance l'activité qui affchie la fenêtre Easy
                        Intent intent = new Intent(MainActivity.this,EasyActivity.class);
                        startActivity(intent);
                    }
                });
                //Confirmation : non
                alertDialog.setNegativeButton("non",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        //rien :)
                        }
                    });
                alertDialog.show();
                }
            });
         /*
         // Gestion du bouton btnTrade associé à la ressource Button Traditionelles
        */
        // Utilisation d'un écouteur d'évenement pour récupérer l'intéraction avec le bouton
        btnTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Demande confirmation avec action
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Traditionnelles");
                alertDialog.setMessage("Voulez vous choisir une recette traditionnelle?");
                //confirmation oui
                alertDialog.setPositiveButton("oui",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), btnTrade.getText(), Toast.LENGTH_SHORT).show();
                        //Lance l'activité qui affchie la fenêtre Traditionnelles
                        Intent intent = new Intent(MainActivity.this, TraditionActivity.class);
                        startActivity(intent);
                    }
                });
                //Confirmation : non
                alertDialog.setNegativeButton("non",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        //rien :)
                    }
                });
                alertDialog.show();
            }
         });
        /*
         // Gestion du bouton btnSaison associé à la ressource Button C'est de saison
        */
        // Utilisation d'un écouteur d'évenement pour récupérer l'intéraction avec le bouton
        btnSaison .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Demande confirmation avec action
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("C'est de saison");
                alertDialog.setMessage("Voulez vous choisir une recette de saison?");
                //confirmation oui
                alertDialog.setPositiveButton("oui",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), btnSaison.getText(), Toast.LENGTH_SHORT).show();
                        //Lance l'activité qui affchie la fenêtre Saisons
                        Intent intent = new Intent(MainActivity.this,SaisonActivity.class);
                        startActivity(intent);
                    }
                });
                //Confirmation : non
                alertDialog.setNegativeButton("non",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        //rien :)
                    }
                });
                alertDialog.show();
            }
        });

        /*
         // Gestion du bouton btnSaison associé à la ressource Button C'est de saison
        */
        // Utilisation d'un écouteur d'évenement pour récupérer l'intéraction avec le bouton
        btnGlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Demande confirmation avec action
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Sans gluten");
                alertDialog.setMessage("Voulez vous choisir une recette sans gluten?");
                //confirmation oui
                alertDialog.setPositiveButton("oui",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), btnGlu.getText(), Toast.LENGTH_SHORT).show();
                        //Lance l'activité qui affchie la fenêtre Glutens
                        Intent intent = new Intent(MainActivity.this,GlutenActivity.class);
                        startActivity(intent);
                    }
                });
                //Confirmation : non
                alertDialog.setNegativeButton("non",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        //rien :)
                    }
                });
                alertDialog.show();
            }
        });


    }
} //end claase
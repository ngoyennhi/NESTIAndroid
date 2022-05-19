package com.example.nesti_mes_recettes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;


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
 */
@Override
public boolean onOptionsItemSelected(@NonNull MenuItem pItem){
    switch (pItem.getItemId()){
        
    }
}
}
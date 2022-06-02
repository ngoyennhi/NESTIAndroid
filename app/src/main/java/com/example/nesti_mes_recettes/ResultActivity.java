package com.example.nesti_mes_recettes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.entity.Recipe;

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
        text_view.setText(term);
    }
}

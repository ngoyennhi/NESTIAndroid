package com.example.nesti_mes_recettes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.nesti_mes_recettes.R;
import com.example.nesti_mes_recettes.ResultActivity;
import com.example.nesti_mes_recettes.TabRecipeActivity;
import com.example.nesti_mes_recettes.entity.Recipe;

import java.util.ArrayList;

public class RecipeAdapterSearch extends ArrayAdapter<Recipe> {
    /*
    Constructeur qui prend deux paramètres
    @param context
    @param textViewResourceId int
    @param recipes
     */
    public RecipeAdapterSearch(@NonNull Context context, int textViewResourceId, ArrayList<Recipe> recipes) {
        super(context, textViewResourceId,recipes);
    }

    /*
     la méthode getView
     */
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View result = convertView;
        if(convertView == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.line_recipe_search,parent,false);
        }
        //get recipe par rapport de sa position dans la liste de resultat de recherche
        Recipe one_recipe = getItem(position);

        //Assigner aux textView la valeur obtenues
        TextView title = result.findViewById(R.id.lineRecipe_txtViewTitle_search);
        title.setText(one_recipe.getTitle());

        //pour les boutons avec ses actions quand on clique
        final Button btnVoir =result.findViewById(R.id.search_btn_voir);

        btnVoir.setOnClickListener(
                new AdapterView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id_recette = one_recipe.getId();
                        // rediger ver TabRecipeActivity
                        Intent intent = new Intent(getContext(),TabRecipeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // putExtra pour envoyer l'id de recette
                        intent.putExtra("id",id_recette);
                        // car on a lancer activity dans adapter donc on a besoin de methode getContext()
                        getContext().startActivity(intent);
                    }
                }
        );
        return result;
    }
}//


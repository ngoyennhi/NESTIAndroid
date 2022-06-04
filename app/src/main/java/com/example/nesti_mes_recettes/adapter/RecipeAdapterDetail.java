package com.example.nesti_mes_recettes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.nesti_mes_recettes.R;
import com.example.nesti_mes_recettes.entity.Recipe;

import java.util.ArrayList;

public class RecipeAdapterDetail extends ArrayAdapter<Recipe> {
    /*
   Constructeur qui prend deux paramètres
   @param context
   @param textViewResourceId int
   @param recipes
    */
    public  RecipeAdapterDetail(@NonNull Context context, int textViewResourceId, ArrayList<Recipe> recipes) {
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
            result = LayoutInflater.from(getContext()).inflate(R.layout.line_recipe_detail,parent,false);
        }
        //get recipe par rapport de sa position dans la liste de resultat de recherche
        Recipe one_recipe = getItem(position);

        //Assigner aux textView la valeur obtenues
        TextView title = result.findViewById(R.id.lineRecipe_txtViewTitle_search);
        title.setText(one_recipe.getTitle());

        TextView author = result.findViewById(R.id.lineRecipe_txtViewAuthor);
        author.setText(one_recipe.getAuthor());

        ImageView imageView =result.findViewById(R.id.lineRecipe_imgViewRecipe);
        imageView.setImageResource(one_recipe.getImgId());

        ImageView imageViewStar =result.findViewById(R.id.lineRecipe_imgViewRecipeStar);
        imageViewStar.setImageResource(one_recipe.getImgIdStar());

        TextView nomPerso = result.findViewById(R.id.lineRecipe_txtViewPerso_detail);
        nomPerso.setText(one_recipe.getNombrePersonne());

        TextView duration = result.findViewById(R.id.lineRecipe_txtViewTemps_detail);
        duration .setText(one_recipe.getNombrePersonne());

        return result;
    }
}//


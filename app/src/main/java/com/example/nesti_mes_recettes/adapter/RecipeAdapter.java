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

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    /*
    Constructeur qui prend deux paramètres
    @param context
    @param textViewResourceId int
    @param recipes
     */
    public RecipeAdapter(@NonNull Context context, int textViewResourceId, ArrayList<Recipe> recipes) {
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
            result = LayoutInflater.from(getContext()).inflate(R.layout.line_recipe,parent,false);
        }
        Recipe one_recipe = getItem(position);

        //Assigner aux textView la valeur obtenues
        TextView title = result.findViewById(R.id.lineRecipe_txtViewTitle);
        title.setText(one_recipe.getTitle());

        TextView author = result.findViewById(R.id.lineRecipe_txtViewAuthor);
        author.setText(one_recipe.getAuthor());

        ImageView imageView =result.findViewById(R.id.lineRecipe_imgViewRecipe);
        imageView.setImageResource(one_recipe.getImgId());

        ImageView imageViewStar =result.findViewById(R.id.lineRecipe_imgViewRecipeStar);
        imageViewStar.setImageResource(one_recipe.getImgIdStar());

        return result;
    }
}
package com.example.nesti_mes_recettes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.nesti_mes_recettes.R;
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
        Recipe one_recipe = getItem(position);

        //Assigner aux textView la valeur obtenues
        TextView title = result.findViewById(R.id.lineRecipe_txtViewTitle);
        title.setText(one_recipe.getTitle());

        return result;
    }
}
package com.example.nesti_mes_recettes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.nesti_mes_recettes.adapter.RecipeAdapter;
import com.example.nesti_mes_recettes.entity.Recipe;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class TraditionActivity<adapter> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradition);
        ////tableau des recettes traditionnelles
        //ArrayList <Recipe> traditional_recipes = new ArrayList<Recipe>();

        //Recipe r1 = new Recipe();
        //r1.setCat("Tradition");
        //r1.setTitle("Macarons");
        //r1.setAuthor("Cédric Grolet");
        // r1.setImgId(this.getResourceImage("r_macarons"));

        // traditional_recipes.add(r1);

        // Recipe r2 = new Recipe();
        // r2.setCat("Tradition");
        // r2.setTitle("Eclair au chocolat");
        // r2.setAuthor("Philipe Conticini");
        // r2.setImgId(this.getResourceImage("r_eclair_chocolat"));
        //  traditional_recipes.add(r2);

        //creat tableau depuis fichier xml
        ArrayList<Recipe> traditional_recipes = readXmlRecipe(R.xml.list_traditional);
        /*
          // List View
         */
        // on attrape le composant pour récuper l'élement Listview du layout par son identifiant
        ListView list_View = findViewById(R.id.Tab_listview);
        // on crée un adaptateur pour faire le lien entre les données et la listView
        // une simple liste d'éléments et alimentée par le tableau de recettes this.eastRecipes
        // deuxieme param détermine l'affichage de chaque élément de la liste
        //utilise notre propre addapter
        RecipeAdapter adapter = new RecipeAdapter(this,R.layout.line_recipe,traditional_recipes);
        // on relie les deux
        list_View.setAdapter(adapter);

    }
    /*
     //Retourne l'identifiant d'une image
     @param nameImage
    @return
    */
    private int getResourceImage(String nameImage){
        String path = getPackageName()+ ":drawable/" + nameImage;
        return getResources().getIdentifier(path,null,null);
    }

    /*
    Lecture des données xml
     */
    private ArrayList<Recipe> readXmlRecipe(int plistId){
        XmlPullParser xml_pull_parser = this.getResources().getXml(plistId);
        ArrayList<Recipe> list_recipes = new ArrayList<>();
    try {
        while((xml_pull_parser.getEventType() != XmlPullParser.END_DOCUMENT)){
            //si la balise est ouvrante
            Log.i("LogNesti","Test");
            if(xml_pull_parser.getEventType() == XmlPullParser.START_TAG){
                if(xml_pull_parser.getName().equals("recipe")){
                    Recipe r = new Recipe();
                    r.setCat(xml_pull_parser.getAttributeValue(null,"cat"));
                    r.setTitle(xml_pull_parser.getAttributeValue(null,"title"));
                    r.setAuthor(xml_pull_parser.getAttributeValue(null,"author"));
                    int i = this.getResourceImage(xml_pull_parser.getAttributeValue(null,"img"));
                    r.setImgId(i);
                    int iStar = this.getResourceImage(xml_pull_parser.getAttributeValue(null,"imgStar"));
                    r.setImgIdStar(iStar);
                    Log.i("LogNesti","Recette : " + r);
                    // alimentation de la liste
                    list_recipes.add(r);
                }
            }
            //Enregistrement suivant
            xml_pull_parser.next();
        }
    }
    catch (XmlPullParserException | IOException e){
    Log.e("LogNesti","Erreurs lecture xml: "+ e.getMessage());

    }
    return list_recipes;
    }
}


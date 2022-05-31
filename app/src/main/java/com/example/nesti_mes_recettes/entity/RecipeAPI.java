package com.example.nesti_mes_recettes.entity;

public class RecipeAPI {
    int id_Cat;
    String cat;
    String nom_de_la_recette;
    String nom;
    String nom_img;
    int difficulte;

    public int getId_Cat() {
        return id_Cat;
    }

    public void setId_Cat(int id_Cat) {
        this.id_Cat = id_Cat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNom_de_la_recette() {
        return nom_de_la_recette;
    }

    public void setNom_de_la_recette(String nom_de_la_recette) {
        this.nom_de_la_recette = nom_de_la_recette;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_img() {
        return nom_img;
    }

    public void setNom_img(String nom_img) {
        this.nom_img = nom_img;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    @Override
    public String toString(){
        return "RecipeAPI{"+
                "id_Cat='"+ id_Cat +"\'" +
                ", cat='" + cat +"\'" +
                ", nom_de_la_recette='" + nom_de_la_recette +"\'" +
                ", nom='" + nom +"\'" +
                ", nom_img='" + nom_img +"\'"+
                ", difficulte='" + difficulte + "}";
    }

}

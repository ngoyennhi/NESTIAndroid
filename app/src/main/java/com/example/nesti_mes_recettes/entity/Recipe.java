package com.example.nesti_mes_recettes.entity;

public class Recipe {
    String title ;
    String cat;
    String author;
    int imgId;
    int imgIdStar;
    int difficulty ;
    int id_Cat;
    int id;

    // Getter-Setter accesseurs-mutateurs

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getImgIdStar() {
        return imgIdStar;
    }

    public void setImgIdStar(int imgIdStar) {
        this.imgIdStar = imgIdStar;
    }

    public int getId_Cat() {
        return difficulty;
    }

    public void setId_Cat(int id_Cat) {
        this.id_Cat = id_Cat;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    @Override
    public String toString(){
        return "Recipe{"+
                "cat='"+ cat +"\'" +
                ", title='" + title +"\'" +
                ", diff='" + difficulty +"\'" +
                ", imgId='" + imgId +
                ", imgIdStar='" + imgIdStar +
                ", author='" + author +"\'" + "}";
    }
}
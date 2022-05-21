package com.example.nesti_mes_recettes.entity;

public class Recipe {
    String title ;
    String cat;
    String author;
    int imgId;
    int imgIdStar;
    // Getter-Setter accesseurs-mutateurs
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

    @Override
    public String toString(){
        return "Recipe{"+
                "cat='"+ cat +"\'" +
                ", title='" + title +"\'" +
                ", imgId='" + imgId +
                ", author='" + author +"\'" + "}";
    }
}

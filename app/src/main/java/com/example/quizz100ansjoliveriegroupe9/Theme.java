package com.example.quizz100ansjoliveriegroupe9;

public class Theme {
    int idTheme;
    String libelleTheme;

    //Construteurs
    public Theme(){

    }
    public Theme(int idTheme, String libelleTheme){
        this.idTheme=idTheme;
        this.libelleTheme=libelleTheme;
    }

    //Setters
    public void setIdTheme(int idTheme){
        this.idTheme=idTheme;
    }

    public void setLibelleTheme(String libelleTheme){
        this.libelleTheme=libelleTheme;
    }

    //Getters

    public int getIdTheme() {
        return this.idTheme;
    }

    public String getLibelleTheme() {
        return this.libelleTheme;
    }
}

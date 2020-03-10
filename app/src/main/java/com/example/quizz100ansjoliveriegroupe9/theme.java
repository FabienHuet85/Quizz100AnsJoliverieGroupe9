package com.example.quizz100ansjoliveriegroupe9;

public class theme {
    private int id_theme;
    private String libelle_theme;

    public theme(int id, String libelle){
        this.id_theme=id;
        this.libelle_theme=libelle;

    }

    public int getId_theme(){
        return id_theme;
    }

    public String getLibelle_theme(){
        return libelle_theme;
    }
}

package com.example.quizz100ansjoliveriegroupe9;

public class reponses {
    private int id_reponse;
    private String libelle_reponse;
    private Boolean reponse_reponse;

    public reponses(int id, String libelle, Boolean reponse){
        this.id_reponse=id;
        this.libelle_reponse=libelle;
        this.reponse_reponse=reponse;

    }

    public int getId_reponse(){
        return id_reponse;
    }

    public String getLibelle_reponse(){
        return libelle_reponse;
    }

    public Boolean getReponse_reponse(){
        return reponse_reponse;
    }
}

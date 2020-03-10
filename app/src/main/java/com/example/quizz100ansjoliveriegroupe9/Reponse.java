package com.example.quizz100ansjoliveriegroupe9;

public class Reponse {
    int idReponse;
    String libelleReponse;
    Boolean vraiFauxReponse;

    //Construteurs
    public Reponse(){

    }
    public Reponse(int idQuestion, String libelleQuestion, Boolean VraiFauxReponse){
        this.idReponse=idReponse;
        this.libelleReponse=libelleReponse;
        this.vraiFauxReponse=VraiFauxReponse;
    }

    //Setters
    public void setIdQReponse(int idReponse){
        this.idReponse=idReponse;
    }

    public void setLibelleReponse(String libelleQuestion){
        this.libelleReponse=libelleReponse;
    }
    
    public void setVraiFauxReponse(Boolean vraiFauxReponse){
        this.vraiFauxReponse=vraiFauxReponse;
    }
    //Getters

    public int getIdReponse() {
        return this.idReponse;
    }

    public String getLibelleReponse() {
        return this.libelleReponse;
    }

    public Boolean getVraiFauxReponse() {
        return this.vraiFauxReponse;
    }
}

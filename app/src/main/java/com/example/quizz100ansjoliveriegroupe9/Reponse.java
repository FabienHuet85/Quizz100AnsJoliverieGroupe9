package com.example.quizz100ansjoliveriegroupe9;

public class Reponse {
    int idReponse;
    String libelleReponse;
    //Boolean vraiFauxReponse;
    int idLaQuestion;

    //Construteurs
    public Reponse(int idReponse, String libelleReponse, int idLaQuestion){
        this.idReponse=idReponse;
        this.libelleReponse=libelleReponse;
        //this.vraiFauxReponse=VraiFauxReponse;
        this.idLaQuestion=idLaQuestion;
    }

    //Setters
    public void setIdQReponse(int idReponse){
        this.idReponse=idReponse;
    }

    public void setLibelleReponse(String libelleReponse){
        this.libelleReponse=libelleReponse;
    }

    /*public void setVraiFauxReponse(Boolean vraiFauxReponse){
        this.vraiFauxReponse=vraiFauxReponse;
    }*/
    //Getters

    public int getIdReponse() {
        return this.idReponse;
    }

    public String getLibelleReponse() {
        return this.libelleReponse;
    }

    /*
    public Boolean getVraiFauxReponse() {
        return this.vraiFauxReponse;
    }*/

    public int getIdLaQuestion() {
        return this.idLaQuestion;
    }
}

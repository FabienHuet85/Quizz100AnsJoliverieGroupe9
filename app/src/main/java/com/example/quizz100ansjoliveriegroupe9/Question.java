package com.example.quizz100ansjoliveriegroupe9;

public class Question {
    int idQuestion;
    String libelleQuestion;

    //Construteurs
    public Question(){

    }
    public Question(int idQuestion, String libelleQuestion){
        this.idQuestion=idQuestion;
        this.libelleQuestion=libelleQuestion;
    }

    //Setters
    public void setIdQuestion(int idQuestion){
        this.idQuestion=idQuestion;
    }

    public void setLibelleQuestion(String libelleQuestion){
        this.libelleQuestion=libelleQuestion;
    }

    //Getters

    public int getIdQuestion() {
        return this.idQuestion;
    }

    public String getLibelleQuestion() {
        return this.libelleQuestion;
    }
}

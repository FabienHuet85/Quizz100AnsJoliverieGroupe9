package com.example.quizz100ansjoliveriegroupe9;

public class questions {
    private int id_question;
    private String libelle_question;

    public questions(int id, String libelle){
        this.id_question=id;
        this.libelle_question=libelle;

    }

    public int getId_question(){
        return id_question;
    }

    public String getLibelle_question(){
        return libelle_question;
    }
}

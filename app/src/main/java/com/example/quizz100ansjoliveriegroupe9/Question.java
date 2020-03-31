package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Question extends AppCompatActivity {
    int idQuestion;
    String libelleQuestion;
    int idLaReponse;
    int idLeTheme;
//Construteurs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);


        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnNext = (Button) findViewById(R.id.btnNext);


        View.OnClickListener ecouteurQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnReturn:
                        Intent intent = new Intent(Question.this, ChoixLieu.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:

                        break;
                }


            }
        };
        btnReturn.setOnClickListener(ecouteurQuestion);
        btnNext.setOnClickListener(ecouteurQuestion);
    }



    public Question(){

    }
    public Question(int idQuestion, String libelleQuestion, int idLaReponse, int idLeTheme){
        this.idQuestion=idQuestion;
        this.libelleQuestion=libelleQuestion;
        this.idLeTheme=idLeTheme;
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

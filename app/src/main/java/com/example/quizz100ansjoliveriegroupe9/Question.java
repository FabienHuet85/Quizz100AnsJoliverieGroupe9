package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

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




        Spinner spinner = (Spinner) findViewById(R.id.Lieu);


        List spinnerTheme = new ArrayList();
        BDAdapter LieuBdd = new BDAdapter(Question.this);
        LieuBdd.open();

        Cursor cursor = LieuBdd.getAllLibelleQuestion();


        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                spinnerTheme.add(cursor.getString(cursor.getColumnIndex("libelle_question")));
            }
        }

        LieuBdd.close();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerTheme);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


























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
        this.idLaReponse=idLaReponse;
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

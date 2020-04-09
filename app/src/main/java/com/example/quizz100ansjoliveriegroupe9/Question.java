package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizz100ansjoliveriegroupe9.data.InsertData;

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


        //Instanciation des éléments d'après ce qui est dans lieu_layout
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        TextView question = (TextView) findViewById(R.id.Question);

        //Création d'une liste pour les elément dans le spinner
        BDAdapter LieuBdd = new BDAdapter(Question.this);

        //Ouverture de la BDD
        LieuBdd.open();
        //Curseur question
         Cursor c = LieuBdd.getAllLibelleTheme();

         //System.out.println(Question.getString(Integer.parseInt(Question.getColumnName(0))));



        // set text dans le textview :


        while (c.moveToNext()) {
            System.out.println("tessssssssst");
            System.out.println("Entrée : " + c.getInt(0) + " / " + c.getString(1));
        }



        //                question.setText(Question.getString("libelle_question"));



        //fermeture de la bdd
        LieuBdd.close();

        View.OnClickListener ecouteurQuestion = new View.OnClickListener() {

            int i=0;

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnReturn:
                        Intent intent = new Intent(Question.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:
                        if (i == 0){
                            Intent intent2 = new Intent(Question.this, Question.class);
                            startActivity(intent2);
                        }else{
                            Toast.makeText(Question.this, "ERREUR - Veuillez selectionner un lieu",Toast.LENGTH_LONG).show();
                        }
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

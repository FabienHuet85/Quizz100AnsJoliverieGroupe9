package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.quizz100ansjoliveriegroupe9.BDAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizz100ansjoliveriegroupe9.data.InsertData;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bd = new BDAdapter(this);
        bd.open();

        InsertData.insertData(this);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Cursor c1 = bd.getAllLibelleTheme();
        //Cursor test = bd.getLibelleTheme(1);



        Cursor c = bd.getAllLibelleTheme();
        Cursor question = bd.getAllQuestions();
        Cursor reponse = bd.getAllReponse();
        Cursor questionAvecTheme = bd.getAllQuestionsWithThemeId(1);
        while (c.moveToNext()) {
            System.out.println("Entrée : " + c.getInt(0) + " / " + c.getString(1));
        }
        System.out.println("Nombre d'entrée : " + c.getCount());

        System.out.println("--------------------------");


        System.out.println("Nombre de questions: " + question.getCount());
        while (question.moveToNext()) {
            System.out.println("Entrée : " + question.getInt(0) + " / " + question.getString(1)+ " / " + question.getInt(2)+ " / " + question.getInt(3));
        }
        System.out.println("--------------------------");


        System.out.println("Nombre de réponses: " + reponse.getCount());
        while (reponse.moveToNext()) {
            System.out.println("Entrée : " + reponse.getInt(0) + " / " + reponse.getString(1)+ " / " + reponse.getInt(2));
        }
        System.out.println("--------------------------");
        System.out.println("Chopper une question en relation avec un thème :");

        questionAvecTheme.moveToNext();
        System.out.println("Question : " + questionAvecTheme.getInt(0) + " / " + questionAvecTheme.getString(1)+ " / " + questionAvecTheme.getInt(2)+ " / " + questionAvecTheme.getInt(3));
        questionAvecTheme.moveToNext();
        System.out.println("Question : " + questionAvecTheme.getInt(0) + " / " + questionAvecTheme.getString(1)+ " / " + questionAvecTheme.getInt(2)+ " / " + questionAvecTheme.getInt(3));

        Button btnNext = (Button) findViewById(R.id.btnNext);

        View.OnClickListener ecouteurAccueil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnNext:
                        Intent intent = new Intent(MainActivity.this, ChoixLieu.class);
                        startActivity(intent);
                        break;

                }
            }
        };

        btnNext.setOnClickListener(ecouteurAccueil);

    }
}

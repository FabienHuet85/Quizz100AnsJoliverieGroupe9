package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
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

        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> question = bundle.getStringArrayList("listeQuestion");
        final ArrayList<String> reponse = bundle.getStringArrayList("listeReponse");
        final ArrayList<String> spinnerTheme = bundle.getStringArrayList("listeTheme");


        final int indiceFenetreOuverte = bundle.getInt("indice_fenetre");
        final  ArrayList<String> bonneReponse = bundle.getStringArrayList("listeBonneReponse");

        final int nbQuestions = question.size();
        int indice2 = indiceFenetreOuverte;

        //test

        //Instanciation des éléments d'après ce qui est dans lieu_layout
        TextView TextViewQuestion = (TextView) findViewById (R.id.Question);
        final Button rep1 = (Button) findViewById(R.id.Reponse1);
        final Button rep2 = (Button) findViewById(R.id.Reponse2);
        final Button rep3 = (Button) findViewById(R.id.Reponse3);
        final Button rep4 = (Button) findViewById(R.id.Reponse4);

        //récupération de la question
        question.get(indiceFenetreOuverte);

        TextViewQuestion.setText(question.get(indiceFenetreOuverte));

        indice2=indiceFenetreOuverte*4;

        rep1.setText(reponse.get(indice2));
        rep2.setText(reponse.get(indice2+1));
        rep3.setText(reponse.get(indice2+2));
        rep4.setText(reponse.get(indice2+3));


        View.OnClickListener ecouteurLieu = new View.OnClickListener() {
            @Override
            public void onClick(View BtnReponse) {
                int btn = 0;
                switch (BtnReponse.getId()) {

                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.Reponse1:

                        test(indiceFenetreOuverte, question, reponse, bonneReponse, rep1, bonneReponse, nbQuestions, spinnerTheme);
                        break;
                    case R.id.Reponse2:
                        test(indiceFenetreOuverte, question, reponse, bonneReponse, rep2, bonneReponse, nbQuestions, spinnerTheme);
                        break;
                    case R.id.Reponse3:
                        test(indiceFenetreOuverte, question, reponse, bonneReponse, rep3, bonneReponse, nbQuestions, spinnerTheme);
                        break;
                    case R.id.Reponse4:
                        test(indiceFenetreOuverte, question, reponse, bonneReponse, rep4, bonneReponse, nbQuestions, spinnerTheme);
                        break;
                }
            }
        };


        rep1.setOnClickListener(ecouteurLieu);
        rep2.setOnClickListener(ecouteurLieu);
        rep3.setOnClickListener(ecouteurLieu);
        rep4.setOnClickListener(ecouteurLieu);







        };

        /*
        btnReturn.setOnClickListener(ecouteurQuestion);
        btnNext.setOnClickListener(ecouteurQuestion);
        */




    public Question() {

    }

    public Question(int idQuestion, String libelleQuestion, int idLaReponse, int idLeTheme) {
        this.idQuestion = idQuestion;
        this.libelleQuestion = libelleQuestion;
        this.idLeTheme = idLeTheme;
        this.idLaReponse = idLaReponse;
    }

    //Setters
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setLibelleQuestion(String libelleQuestion) {
        this.libelleQuestion = libelleQuestion;
    }

    //Getters

    public int getIdQuestion() {
        return this.idQuestion;
    }

    public String getLibelleQuestion() {
        return this.libelleQuestion;
    }

    public int getIdLaReponse() {
        return this.idLaReponse;
    }

    public int getIdLeTheme() {
        return this.idLeTheme;
    }

    protected void test (int indiceFenetreOuverte,ArrayList question, ArrayList reponse, ArrayList listeBonneReponse, Button rep, ArrayList bonneReponse, int nbQuestions, ArrayList spinnerTheme){
        final int indicefenetresuivant = indiceFenetreOuverte+1;
        Intent intent = new Intent(Question.this, Question.class);
        Intent intent2 = new Intent(Question.this, ChoixLieu.class);
        intent.putExtra("listeQuestion",question);
        intent.putExtra("listeReponse",reponse);
        intent.putExtra("listeTheme",spinnerTheme);
        intent.putExtra("indice_fenetre",indicefenetresuivant);
        intent.putExtra("listeBonneReponse",reponse);

        int tailleListBonneReponse = bonneReponse.size();

        //Récupération du string de la réponse choisir
        CharSequence reponseChoisie = rep.getText();
        String reponseChoisieString = reponseChoisie.toString();

        //Récupération de la BDD
        BDAdapter Bdd = new BDAdapter(Question.this);

        //Ouverture de la BDD
        Bdd.open();

        Cursor getidreponsewithlibelle = Bdd.getIdReponsesWithLibelleReponse(reponseChoisieString);
        getidreponsewithlibelle.moveToNext();
        int idReponseSelec = getidreponsewithlibelle.getInt(0);
        String idStringReponseSelec = String.valueOf(idReponseSelec);

        int j = 0;
        int vraiOuFaux = 0; //Si valeur = 0 : Faux -- Si valeur = 1 : Vrai
        while((j<tailleListBonneReponse)&&(vraiOuFaux==0)){
            if((bonneReponse.get(j)).equals(idStringReponseSelec)){
                vraiOuFaux = 1;
            }else{
                j++;
            }
        }
        if (vraiOuFaux==0){
            Toast toast = Toast.makeText(this, "Mauvaise réponse", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(this, "Bonne réponse", Toast.LENGTH_SHORT);
            toast.show();
        }
        Bdd.close();

        System.out.println(reponse.get(0));
        System.out.println("----------------------");


        if(indicefenetresuivant == nbQuestions ) {

            //Déclaration du bundle pour pouvoir envoyer les données dedans
            Bundle bundle = new Bundle();

            bundle.putStringArrayList("listeTheme ", spinnerTheme);
            intent2.putExtra("listeTheme",spinnerTheme);

            //insertion des données à passer dans le intent
            intent2.putExtras(bundle);

            startActivity(intent2);
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }else{
            startActivity(intent);
        }
    }
}
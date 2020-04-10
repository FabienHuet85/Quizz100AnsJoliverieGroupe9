package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.quizz100ansjoliveriegroupe9.Theme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChoixLieu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lieu_layout);

        //Instanciation des éléments d'après ce qui est dans lieu_layout
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        final Spinner spinner = (Spinner) findViewById(R.id.Lieu);

        //Création d'une liste pour les elément dans le spinner
        final List spinnerTheme = new ArrayList();
        BDAdapter LieuBdd = new BDAdapter(ChoixLieu.this);
        //Ouverture de la BDD
        LieuBdd.open();

        //Curseur pour obtenir touts les thèmes
        Cursor cursor = LieuBdd.getAllLibelleTheme();

        //Boucle pour l'import des valeurs dans la liste déroulante :
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                spinnerTheme.add(cursor.getString(cursor.getColumnIndex("libelle_theme")));
            }
        }

        //fermeture de la bdd
        LieuBdd.close();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerTheme);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        View.OnClickListener ecouteurLieu = new View.OnClickListener() {

            int i=0;

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnReturn:
                        Intent intent = new Intent(ChoixLieu.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:
                        if (i == 0){

                            //Récupération du libellé du thème selectionner
                            String nom_theme_selectionne = spinner.getSelectedItem().toString();

                            //Récupération de la BDD
                            BDAdapter Bdd = new BDAdapter(ChoixLieu.this);

                            //Ouverture de la BDD
                            Bdd.open();

                            //Récupération de l'id du thème sélectionner
                            Cursor themeSelectionner = Bdd.getIdThemeWithLibelle(nom_theme_selectionne);
                            themeSelectionner.moveToNext();
                            int idThemeEnCours = themeSelectionner.getInt(0);

                            //Récupération des questions en lien avec le thème sélectionner
                            Cursor questionLieesAuThemeSelec = Bdd.getAllQuestionsWithThemeId(idThemeEnCours);

                            //Récupération du nombre de questions
                            int nbQuestion = questionLieesAuThemeSelec.getCount();

                            //Déclaration des listes dans lesquelles on va stocker les questions et les réponses
                            ArrayList<String> reponse = new ArrayList<>();
                            int idVraiReponse [] = new int[nbQuestion];
                            ArrayList<String> bonneReponse = new ArrayList<>();
                            ArrayList<String> question = new ArrayList<>();


                            //on parcours les questions liées au thème
                            while(questionLieesAuThemeSelec.moveToNext()){
                                i=0;
                                //On récupère l'id des questions en lien avec le thème
                                int idQuestionParcours = questionLieesAuThemeSelec.getInt(0);

                                //On récupère l'id de la réponse qui est vrai sur les quatre question liée à la question
                                //et on le stock dans le tableau qui a les id des bonnes réponses
                                idVraiReponse[i] = questionLieesAuThemeSelec.getInt(2);
                                String libelleBonneReponse = String.valueOf(idVraiReponse[i]);
                                bonneReponse.add(libelleBonneReponse);

                                //On ajoute le libellé de la question liée au thème dans la liste
                                question.add(questionLieesAuThemeSelec.getString(1));

                                //On récupère les quatre réponses liées à l'id de la question
                                Cursor Reponse = Bdd.getAllReponses(idQuestionParcours);

                                //On parcours les question pour stocker leur libellé dans une liste
                                while (Reponse.moveToNext()) {
                                    System.out.println(Reponse.getString(1));
                                    reponse.add(Reponse.getString(1));
                                }
                            }

                            int indiceFenêtreOuvert = 0;
                            //Déclaration de l'intent pour envoyer des données dans l'autre interface
                            Intent intent2 = new Intent(ChoixLieu.this, Question.class);

                            //Déclaration du bundle pour pouvoir envoyer les données dedans
                            Bundle bundle = new Bundle();

                            //Insertion des données à envoyer dans le bundle
                            bundle.putString("nom_theme_selec ", nom_theme_selectionne);
                            bundle.putStringArrayList("listeQuestion ", question);
                            bundle.putStringArrayList("listeReponse ", reponse);
                            bundle.putInt("indice_fenetre",indiceFenêtreOuvert);

                            intent2.putExtra("nom_theme_selec",nom_theme_selectionne);
                            intent2.putExtra("listeQuestion",question);
                            intent2.putExtra("listeReponse",reponse);
                            intent2.putExtra("indice_fenetre",indiceFenêtreOuvert);
                            intent2.putExtra("listeBonneReponse",bonneReponse);

                            //insertion des données à passer dans le intent
                            intent2.putExtras(bundle);

                            startActivity(intent2);

                            //test
                        }else{
                            Toast.makeText(ChoixLieu.this, "ERREUR - Veuillez selectionner un lieu",Toast.LENGTH_LONG).show();
                        }
                        break;
                }


            }
        };


        btnReturn.setOnClickListener(ecouteurLieu);
        btnNext.setOnClickListener(ecouteurLieu);


    }
}

package com.example.quizz100ansjoliveriegroupe9;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizz100ansjoliveriegroupe9.BDAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizz100ansjoliveriegroupe9.data.InsertData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bd = new BDAdapter(this);
        bd.open();

        InsertData.insertData(this);

        Cursor c = bd.getAllLibelleTheme();
        Cursor question = bd.getAllLibelleQuestion();
        Cursor reponse = bd.getAllReponse();
        Cursor questionAvecTheme = bd.getAllQuestionsWithThemeId(1);


        Button btnNext = (Button) findViewById(R.id.btnNext);

        View.OnClickListener ecouteurAccueil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnNext:

                        String prenom = "";
                        //on récupère le EditText
                        EditText editTextPrenom = (EditText) findViewById (R.id.Name);
                        //on récupèrer le prénom
                        prenom = editTextPrenom.getText().toString();
                        if(prenom.equals("")){
                            TextView errormessage = (TextView) findViewById (R.id.ErrorMessage);
                            errormessage.setText("Veuillez renseigner votre prénom !");


                        }else{
                            //Création d'une liste pour les elément dans le spinner
                            ArrayList<String> spinnerTheme = new ArrayList<>();
                            BDAdapter LieuBdd = new BDAdapter(MainActivity.this);

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

                            //Déclaration du bundle pour pouvoir envoyer les données dedans
                            Bundle bundle = new Bundle();

                            //Déclaration de l'intent
                            Intent intent = new Intent(MainActivity.this, ChoixLieu.class);

                            bundle.putStringArrayList("listeTheme ", spinnerTheme);
                            intent.putExtra("listeTheme",spinnerTheme);

                            //insertion des données à passer dans le intent
                            intent.putExtras(bundle);


                            startActivity(intent);
                            break;
                        }

                }
            }
        };

        btnNext.setOnClickListener(ecouteurAccueil);

    }
}

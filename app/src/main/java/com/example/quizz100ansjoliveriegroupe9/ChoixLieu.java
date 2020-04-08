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
        Spinner spinner = (Spinner) findViewById(R.id.Lieu);

        //Création d'une liste pour les elément dans le spinner
        List spinnerTheme = new ArrayList();
        BDAdapter LieuBdd = new BDAdapter(ChoixLieu.this);
        //Ouverture de la BDD
        LieuBdd.open();

        //Curseur pour
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
                        Intent intent2 = new Intent(ChoixLieu.this, Question.class);
                        startActivity(intent2);
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

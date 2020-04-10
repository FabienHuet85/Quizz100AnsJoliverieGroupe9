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
                        System.out.println("////////////////////////////////////////////");
                        prenom = editTextPrenom.getText().toString();
                        System.out.println(prenom);
                        System.out.println("//////////////////////////////");
                        if(prenom.equals("")){
                            TextView errormessage = (TextView) findViewById (R.id.ErrorMessage);
                            errormessage.setText("Veuillez renseigner votre prénom !");


                        }else{
                            Intent intent = new Intent(MainActivity.this, ChoixLieu.class);
                            startActivity(intent);
                            break;
                        }

                }
            }
        };

        btnNext.setOnClickListener(ecouteurAccueil);

    }
}

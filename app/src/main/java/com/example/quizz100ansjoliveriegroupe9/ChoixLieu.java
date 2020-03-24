package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixLieu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lieu_layout);




        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnNext = (Button) findViewById(R.id.btnNext);


        View.OnClickListener ecouteurAccueil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnReturn:
                        Intent intent = new Intent(ChoixLieu.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:
                        //Intent intent2 = new Intent(ChoixLieu.this, x.class);
                        //startActivity(intent2);
                        break;
                }


            }
        };
        btnReturn.setOnClickListener(ecouteurAccueil);
        btnNext.setOnClickListener(ecouteurAccueil);


    }
}

package com.example.quizz100ansjoliveriegroupe9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bd = new BDAdapter(this);
        bd.open();

        Theme unTheme = new Theme (1, "Nantes");
        Theme unTheme2 = new Theme (2, "Paris");

        bd.insererTheme(unTheme);
        bd.insererTheme(unTheme2);

        bd.close();
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

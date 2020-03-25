package com.example.quizz100ansjoliveriegroupe9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bd = new BDAdapter(this);
        bd.open();

//        bd.getDb().delete("TABLE_THEME", null, null);

//        String req = "DROP TABLE TABLE_THEME";
//        bd.getDb().execSQL(req);

//        Theme unTheme = new Theme (1, "Nantes");
//        Theme unTheme2 = new Theme (2, "Paris");
//        Theme unTheme3 = new Theme (3, "dd");
//        bd.deleteAll();

//        bd.createTableTheme();

        bd.insererTheme(new Theme(0, "Nantes"));
        bd.insererTheme(new Theme(0, "Paris"));
        bd.insererTheme(new Theme(0, "Nice"));


        Cursor c = bd.getAllLibelleTheme();
        System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLO");
        while (c.moveToNext()) {
            System.out.println("Entrée : " + c.getInt(0) + " / " + c.getString(1));
        }
        System.out.println("Nombre d'entrée : " + c.getCount());
        Toast.makeText(getApplicationContext(), "Il y a " + String.valueOf(c.getCount()) + " articles dans la BDD", Toast.LENGTH_LONG).show();


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

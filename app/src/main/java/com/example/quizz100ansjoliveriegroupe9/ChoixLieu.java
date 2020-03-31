package com.example.quizz100ansjoliveriegroupe9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.quizz100ansjoliveriegroupe9.Theme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class ChoixLieu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lieu_layout);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        Button btnNext = (Button) findViewById(R.id.btnNext);



        View.OnClickListener ecouteurLieu = new View.OnClickListener() {

            int i;

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //Boutons permettant d'ouvrir les différentes activitiés
                    case R.id.btnReturn:
                        Intent intent = new Intent(ChoixLieu.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnNext:
                        if (i == 1){
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

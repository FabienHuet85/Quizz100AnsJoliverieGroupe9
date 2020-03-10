package com.example.quizz100ansjoliveriegroupe9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    //Database Helper
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseHelper(getApplicationContext());
    }
}

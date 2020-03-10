package com.example.quizz100ansjoliveriegroupe9;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG = "DatabaseHelper";

    //Version de la BDD
    private static final int DATABASE_VERSION = 1;

    //Nom de la BDD
    private static final String DATABASE_NAME = "QuizzBDD";

    //Nom des Tables
    private static final String TABLE_QUESTION = "questions";
    private static final String TABLE_REPONSE = "reponses";
    private static final String TABLE_THEME = "themes";

    //Table reponses - colonne
    private static final String KEY_REPONSE_ID = "reponse_id";
    private static final String KEY_REPONSE_LIBELLE = "reponse_libelle";
    private static final String KEY_REPONSE_VRAIFAUX = "reponse_vraixfaux";

    //Table questions - colonne
    private static final String KEY_QUESTION_ID = "question_id";
    private static final String KEY_QUESTION_LIBELLE = "question_libelle";

    //Table themes - colonne
    private static final String KEY_THEME_ID = "theme_id";
    private static final String KEY_THEME_LIBELLE = "theme_libelle";


    //-- Création des tables --
    //Création de la table reponses
    private static final String CREATE_TABLE_REPONSE = "CREATE TABLE " + TABLE_REPONSE +
            "(" + KEY_REPONSE_ID + " INTEGER PRIMARY KEY," + KEY_REPONSE_LIBELLE +
            " TEXT," + KEY_REPONSE_VRAIFAUX + " BOOLEAN" + ")";

    //Création de la table questions
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE " + TABLE_QUESTION +
            "(" + KEY_QUESTION_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_LIBELLE +
            " TEXT" + ")";

    //Création de la table theme
    private static final String CREATE_TABLE_THEME = "CREATE TABLE " + TABLE_THEME +
            "(" + KEY_THEME_ID + " INTEGER PRIMARY KEY," + KEY_THEME_LIBELLE +
            " TEXT" + ")";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //Creation des tables requises
        db.execSQL(CREATE_TABLE_REPONSE);
        db.execSQL(CREATE_TABLE_QUESTION);
        db.execSQL(CREATE_TABLE_THEME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Modification des table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPONSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THEME);
    }

}

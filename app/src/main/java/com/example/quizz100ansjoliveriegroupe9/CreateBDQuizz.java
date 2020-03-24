package com.example.quizz100ansjoliveriegroupe9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CreateBDQuizz extends SQLiteOpenHelper{
    private static final String TAG = "CreateBDQuizz";

    public static String DATABASE_NAME = "quizz_database";

    //Les différentes tables de la bdd
    static final String TABLE_QUESTION = "table_question";
    static final String TABLE_REPONSE = "table_reponse";
    static final String TABLE_THEME = "table_theme";

    //colonnes communes a chaque table
    private static final String COL_ID = "_id";

    //colonnes des différentes tables
    private static final String COL_TEXT_QUESTION = "libelle_question";
    private static final String COL_TEXT_REPONSE = "libelle_reponse";
    private static final String COL_BOOLEAN_REPONSE = "vraifaux_reponse";
    private static final String COL_TEXT_THEME = "libelle_theme";

    //création des requetes sql pour créer les tables
    private static final String CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_QUESTION + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_TEXT_QUESTION + " TEXT NOT NULL," + "idLaReponse INT, idLeTheme INT, CONSTRAINT fk_question_theme FOREIGN KEY (idLeTheme) REFERENCES Theme(idTheme), CONSTRAINT fk_question_reponse FOREIGN KEY (idLaReponse) REFERENCES Reponse(idReponse)); ";
    private static final String CREATE_REPONSE_TABLE = "CREATE TABLE " + TABLE_REPONSE + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_TEXT_REPONSE + " TEXT NOT NULL ," + COL_BOOLEAN_REPONSE + " BOOLEAN NOT NULL);";
    private static final String CREATE_THEME_TABLE = "CREATE TABLE " + TABLE_THEME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_TEXT_THEME + " TEXT NOT NULL);";

    //constructeur paramétré
    public CreateBDQuizz(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //méthodes d'instance permettant la gestion de l'objet
    public void onCreate(SQLiteDatabase db){
        Log.d(TAG, "onCreate ... ");

        // appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_QUESTION_TABLE);
        db.execSQL(CREATE_REPONSE_TABLE);
        db.execSQL(CREATE_THEME_TABLE);
    }

    // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade ... ");

        //On peut  supprimer la table et de la recréer
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPONSE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THEME + ";");

        onCreate(db);
    }

}

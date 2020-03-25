package com.example.quizz100ansjoliveriegroupe9;

import android.content.ContentValues;
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
    static final String TABLE_THEME = "TABLE_THEME";

    //colonnes communes a chaque table
    private static final String COL_ID = "_id";

    //colonnes des différentes tables
    //Table question
    private static final String COL_TEXT_QUESTION = "libelle_question";
    private static final String COL_TEXT_IDLAREPONSE = "idlareponse"; //Id bonne réponse
    private static final String COL_TEXT_IDLETHEME = "idletheme";

    //table reponse
    private static final String COL_TEXT_REPONSE = "libelle_reponse";
    private static final String COL_TEXT_IDLAQUESTION = "idLaQuestion";
    // Si l'id de la response de notre question est le nôtre, on est vrai sinon on est faux

    //table theme
    private static final String COL_TEXT_THEME = "libelle_theme";

    //création des requetes sql pour créer les tables
    private static final String CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_QUESTION + " (" + COL_ID + " INTEGER PRIMARY KEY UNIQUE,"+ COL_TEXT_QUESTION + " TEXT NOT NULL," + COL_TEXT_IDLAREPONSE + " INT NOT NULL," + COL_TEXT_IDLETHEME + " INT NOT NULL );";
    private static final String CREATE_REPONSE_TABLE = "CREATE TABLE " + TABLE_REPONSE + " (" + COL_ID + " INTEGER PRIMARY KEY UNIQUE, "+ COL_TEXT_REPONSE + " TEXT NOT NULL ," + COL_TEXT_IDLAQUESTION + " INT NOT NULL );";
    public static final String CREATE_THEME_TABLE = "CREATE TABLE " + TABLE_THEME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_TEXT_THEME + " TEXT NOT NULL);";

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
/*
    public long insererQuestion (Question uneQuestion){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_QUESTION, uneQuestion.getLibelleQuestion());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_QUESTION, null, values);
    }

    public long insererReponse (Reponse uneReponse){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_REPONSE, uneReponse.getLibelleReponse());
        values.put(COL_BOOLEAN_REPONSE, uneReponse.getVraiFauxReponse());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_REPONSE, null, values);
    }

    public long insererTheme (Theme unTheme){
        Log.d(TAG, "récupération du lieu dans insererLieu : " + unTheme);
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_THEME, unTheme.getLibelleTheme());
        Log.d(TAG, "values : " + values.toString());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_THEME, null, values);
    }*/
}

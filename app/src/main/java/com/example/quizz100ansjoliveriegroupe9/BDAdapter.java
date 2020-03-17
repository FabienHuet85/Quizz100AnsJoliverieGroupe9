package com.example.quizz100ansjoliveriegroupe9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quizz100ansjoliveriegroupe9.Question;
import com.example.quizz100ansjoliveriegroupe9.Reponse;
import com.example.quizz100ansjoliveriegroupe9.Theme;

public class BDAdapter {
    private static final String TAG = "BDAdapter";
    static final int VERSION_BDD = 2;
    private static final String NOM_BDD = "quizz.db";
    static final String TABLE_QUESTION = "table_question";
    static final String TABLE_REPONSE = "table_reponse";
    static final String TABLE_THEME = "table_theme";

    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_TEXT_QUESTION = "libelle_question";
    static final int NUM_COL_TEXT_QUESTION = 1;
    static final String COL_TEXT_REPONSE = "libelle_reponse";
    static final int NUM_COL_TEXT_REPONSE = 2;
    static final String COL_BOOLEAN_REPONSE = "vraifaux_reponse";
    static final int NUM_COL_BOOLEAN_REPONSE = 3;
    static final String COL_TEXT_THEME = "libelle_theme";
    static final int NUM_COL_TEXT_THEME = 4;




    private CreateBDQuizz bdQuizz;
    private Context context;
    private SQLiteDatabase db;

    //le constructeur
    public BDAdapter (Context context){
        this.context = context;
        bdQuizz = new CreateBDQuizz(context, NOM_BDD, null, VERSION_BDD);
    }

    //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la base a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra  la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour

    //les méthodes d'instance
    public BDAdapter  open(){
        db = bdQuizz.getWritableDatabase();
        return this;
    }
    public BDAdapter  close(){
        db.close();
        return null;
    }

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
    }



}

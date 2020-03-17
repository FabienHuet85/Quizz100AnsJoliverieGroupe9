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



}

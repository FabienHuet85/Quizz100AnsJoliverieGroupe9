package com.example.quizz100ansjoliveriegroupe9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BDAdapter {
    private static final String TAG = "BDAdapter";
    static final int VERSION_BDD = 2;
    private static final String NOM_BDD = "quizz100.db";
    static final String TABLE_QUESTION = "table_question";
    static final String TABLE_REPONSE = "table_reponse";
    static final String TABLE_THEME = "TABLE_THEME";

    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;

    //Champ de la table Question
    static final String COL_TEXT_QUESTION = "libelle_question";
    static final int NUM_COL_TEXT_QUESTION = 1;
    static final String COL_IDLAREPONSE_QUESTION = "id_la_reponse";
    static final int NUM_COL_IDLAREPONSE_QUESTION = 2;
    static final String COL_IDLETHEME_QUESTION = "idLeTheme";
    static final int NUM_IDLETHEME_QUESTION = 3;

    //Champ de la table Reponse
    static final String COL_TEXT_REPONSE = "libelle_reponse";
    static final int NUM_COL_TEXT_REPONSE = 4;
    /*
    static final String COL_VRAIXFAUX_REPONSE = "vraixfaux_reponse";
    static final int NUM_COL_VRAIXFAUX_REPONSE = 5;
     */
    static final String COL_IDLAQUESTION_REPONSE = "id_la_question";
    static final int NUM_COL_IDLAQUESTION_REPONSE = 5;

    //Champ de la table Theme
    static final String COL_TEXT_THEME = "libelle_theme";
    static final int NUM_COL_TEXT_THEME = 6;


    private CreateBDQuizz bdQuizz;
    private SQLiteDatabase db;

    //le constructeur
    public BDAdapter(Context context) {
        bdQuizz = new CreateBDQuizz(context, NOM_BDD, null, VERSION_BDD);
    }

    //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la base a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra  la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour

    //les méthodes d'instance
    public BDAdapter open() {
        db = bdQuizz.getWritableDatabase();
        return this;
    }

    public BDAdapter close() {
        db.close();
        return null;
    }

    public long insererQuestion(Question uneQuestion) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_QUESTION, uneQuestion.getLibelleQuestion());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_QUESTION, null, values);
    }

    public long insererTheme(Theme unTheme) {
        Log.d(TAG, "récupération du theme dans insererTheme : " + unTheme);
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
//        values.put("_id", unTheme.getIdTheme()); // Automatique
        values.put(COL_TEXT_THEME, unTheme.getLibelleTheme());
        Log.d(TAG, "values : " + values.toString());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_THEME, null, values);
    }

    public long insererReponse(Reponse uneReponse) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_REPONSE, uneReponse.getLibelleReponse());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_REPONSE, null, values);
    }


    public Cursor getLibelleTheme(int id_theme) {
        return db.rawQuery("SELECT * FROM TABLE_THEME WHERE TABLE_THEME._id =" + id_theme, null);
    }

    public Cursor getAllLibelleTheme() {

        return db.rawQuery("SELECT * FROM TABLE_THEME;", null);
    }

    public Cursor getAllLibelleQuestion() {

        return db.rawQuery("SELECT * FROM table_question;", null);
    }

    //requêtes liées aux questions
    public Cursor getAllQuestionsWithThemeId(int id_theme) {
        return db.rawQuery("SELECT * FROM TABLE_QUESTION WHERE "+COL_IDLETHEME_QUESTION+" = "+id_theme, null);
    }

    public Cursor getLibelleQuestionId(int idquestion, int id_theme) {
        return db.rawQuery("SELECT * FROM TABLE_QUESTION WHERE TABLE_QUESTION._id =" + idquestion+" AND "+COL_IDLETHEME_QUESTION+" = "+id_theme,null);
    }

    public Cursor getOneQuestion(int idquestion){
        return db.rawQuery("SELECT * FROM table_question WHERE table_question._id="+ idquestion,null);
    }

    //requêtes liées aux réponses
    public Cursor getAllReponses(int id_question) {
        return db.rawQuery("SELECT * FROM TABLE_REPONSE WHERE "+COL_IDLAQUESTION_REPONSE+" = "+id_question, null);
    }

    public Cursor getLibelleReponsesId(int id_reponse, int id_question) {
        return db.rawQuery("SELECT * FROM table_question WHERE TABLE_REPONSE._id = " + id_reponse +" WHERE "+COL_IDLAQUESTION_REPONSE+" = "+id_question,null);
    }


    public void deleteAll() {
        db.delete(TABLE_THEME, null, null);
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void createTableTheme() {
        this.db.execSQL(CreateBDQuizz.CREATE_THEME_TABLE);
    }
}

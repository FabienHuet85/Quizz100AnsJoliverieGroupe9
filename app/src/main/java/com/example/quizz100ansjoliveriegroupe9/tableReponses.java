package com.example.quizz100ansjoliveriegroupe9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//https://www.supinfo.com/articles/single/5151-developpement-android-base-donnees-sqlite
public class tableReponses extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Quizz.db";
    public static final String TABLE_NAME ="REPONSES";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="LIBELLE";
    public static final String COL_3 ="REPONSE";

    public tableReponses(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +  TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE TEXT, REPONSE BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

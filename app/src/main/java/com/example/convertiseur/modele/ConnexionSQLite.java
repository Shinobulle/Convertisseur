package com.example.convertiseur.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnexionSQLite extends SQLiteOpenHelper {
    private static final String DB_NAME = "devises";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME ="monnaies";
    private static final String MONNAIE_COL = "monnaie";
    private static final String TAUX_COL = "taux";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " (" + MONNAIE_COL+ " TEXT PRIMARY KEY, "+
            TAUX_COL+ " INTEGER)";
    private static final String INSERT_MONNAIE = "INSERT INTO `monnaies` (`monnaie`, `taux`) VALUES\n" +
            "('Dirham', 8.5656),\n" +
            "('Dollars CA', 1.1),\n" +
            "('Dollars US', 1),\n" +
            "('Euro', 0.7697),\n" +
            "('Franc', 5.049),\n" +
            "('Franc CFA', 503.17),\n" +
            "('Livre', 0.6405),\n" +
            "('Yen', 76.6908);";

    public ConnexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
        db.execSQL(INSERT_MONNAIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}

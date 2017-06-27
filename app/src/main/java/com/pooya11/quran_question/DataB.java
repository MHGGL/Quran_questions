package com.pooya11.quran_question;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.widget.Toast;


public class DataB extends SQLiteOpenHelper {

    public DataB(Context context) {
        super(context, "Questions", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SevenFragment(id INTEGER AUTO INCREMENT," +
                " number_test INTEGER," +
                " question TEXT, number_one TEXT," +
                " number_two TEXT," +
                " number_three TEXT," +
                " number_four TEXT,"+
                " number_true TEXT)");

        db.execSQL("CREATE TABLE EightFragment(id INTEGER AUTO INCREMENT," +
                " number_test VARCHAR(255)," +
                " question TEXT, number_one TEXT," +
                " number_two TEXT," +
                " number_three TEXT," +
                " number_four TEXT,"+
                " number_true TEXT)");

        db.execSQL("CREATE TABLE NineFragment(id INTEGER AUTO INCREMENT," +
                " number_test VARCHAR(255)," +
                " question TEXT, number_one TEXT," +
                " number_two TEXT," +
                " number_three TEXT," +
                " number_four TEXT,"+
                " number_true TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Questions");
        onCreate(db);
    }
}

package com.example.hpfolio.reapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP FOLIO on 12/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String database_name = "MyDatabase";
    private static final String table_name = "signup";
    private static final String table_col_name = "signup";
    private static final int db_version = 1;

    public DatabaseHelper(Context context) {
        super(context, database_name, null, db_version);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + table_name + "( user_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name VARCHAR,user_email VARCHAR,user_password VARCHAR,user_phone VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public long signup(String name, String email, String password, String phone) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name", name);
        contentValues.put("user_email", email);
        contentValues.put("user_password", password);
        contentValues.put("user_phone", phone);
        long user_data = sqLiteDatabase.insert(table_name, null, contentValues);
        return user_data;

    }

    public Cursor login(String email, String password) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor user_data = sqLiteDatabase.rawQuery("SELECT * from " + table_name + " WHERE user_email='" + email + "'" + "AND user_password ='" + password + "'", null);

        return user_data;
    }
}

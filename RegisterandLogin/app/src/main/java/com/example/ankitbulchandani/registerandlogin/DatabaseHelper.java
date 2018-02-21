package com.example.ankitbulchandani.registerandlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ankit Bulchandani on 27-01-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Students_info2.db";
    public static final String TABLE_NAME ="Students_table2";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="FIRSTNAME";
    public static final String COL_3 ="LASTNAME";
    public static final String COL_4 ="EMAIL";
    public static final String COL_5 ="USERNAME";
    public static final String COL_6 ="PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,LASTNAME TEXT,EMAIL TEXT,USERNAME TEXT,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String firstname,String lastname,String email,String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,firstname);
        contentValues.put(COL_3,lastname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,username);
        contentValues.put(COL_6, password);

       long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
            else
            return  true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;


    }
}


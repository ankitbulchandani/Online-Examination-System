//package com.example.ankitbulchandani.registerandlogin;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
// * Created by Ankit Bulchandani on 01-03-2016.
// */
//public class AdminDatabase extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "Questions.db";
//    public static final String TABLE_NAME = "questions_table";
//    public static final String COL_1 = "ID";
//    public static final String COL_2 = "QUESTIONS";
//    public static final String COL_3 = "OPTION1";
//    public static final String COL_4 = "OPTION2";
//    public static final String COL_5 = "OPTION3";
//    public static final String COL_6 = "OPTION4";
//    public static final String COL_7 = "CORRECT_ANS";
//
//    public AdminDatabase(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,QUESTIONS TEXT,OPTION1 TEXT,OPTION2 TEXT,OPTION3 TEXT,OPTION4 TEXT,CORRECT_ANS TEXT) ");
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        db.execSQL("DROP table IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//
//    }
//
//    public boolean insertData(String Questions, String Option1, String Option2, String Option3, String Option4, String Correct_ans) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, Questions);
//        contentValues.put(COL_3, Option1);
//        contentValues.put(COL_4, Option2);
//        contentValues.put(COL_5, Option3);
//        contentValues.put(COL_6, Option4);
//        contentValues.put(COL_7, Correct_ans);
//        long result = db.insert(TABLE_NAME, null, contentValues);
//
//        if (result == -1)
//            return false;
//        else return true;
//
//    }
//
//
//
//    public Cursor getAllData()
//    {
//        SQLiteDatabase db =this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
//        return res;
//
//
//    }
//
//
//    public boolean updateData(String id,String Questions, String Option1, String Option2, String Option3, String Option4, String Correct_ans)
//    {
//        SQLiteDatabase db =this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_1,id);
//        contentValues.put(COL_2, Questions);
//        contentValues.put(COL_3, Option1);
//        contentValues.put(COL_4, Option2);
//        contentValues.put(COL_5, Option3);
//        contentValues.put(COL_6, Option4);
//        contentValues.put(COL_7, Correct_ans);
//        db.update(TABLE_NAME,contentValues,"ID = ?",new String[]{id});
//        return true;
//
//
//    }
//
//    public Integer deleteData(String id){
//        SQLiteDatabase db =this.getWritableDatabase();
//        db.delete(TABLE_NAME, "ID = ?", new String[]{id});
//        return 0;
//    }
//
//}

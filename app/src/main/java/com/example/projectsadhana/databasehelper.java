package com.example.projectsadhana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper extends SQLiteOpenHelper {
   //constructor to create a sqlite database
    public databasehelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table report (rounds varchar(20),wakeuptime varchar(20), studytime varchar(20))");
    }
    //dropping table when version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists report");
        onCreate(db);
    }
    //user defined function to save user data
    public long saveNewUserData(String rounds, String wakeuptime, String studytime){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("rounds",rounds);
        cv.put("wakeuptime",wakeuptime);
        cv.put("studytime",studytime);
        long recordid= db.insert("report",null,cv);
        return recordid;
    }

    //function to view all the records
    public String getAllRecords(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from report",null);
        //cursor object is virtual table, has cursor pointer, before the first record, move to first record
        //then we can read
        String output="";
        while(cursor.moveToNext()){
            String rounds=cursor.getString(0);
            String wakeuptime=cursor.getString(1);
            String studytime=cursor.getString(2);
            output=output + rounds+"-"+wakeuptime+"-"+studytime+"\n";
        }
        return output;
    }
}

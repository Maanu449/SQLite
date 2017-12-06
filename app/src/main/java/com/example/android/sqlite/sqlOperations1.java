package com.example.android.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class sqlOperations1 extends SQLiteOpenHelper {

    //database version
    private static final int dbversion = 1;

    //database name
    private static final String dbname ="Students";

    //table name
    private static final String tblname = "Student_Details";

    //name of heads of table columns
    private static final String COL1 = "Roll. No.";
    private static final String COL2 = "Name of Student";

    //parameterised constructor

    public sqlOperations1(Context context){
        super(context, dbname, null, dbversion);
    }

    //creating tables
    @Override
    public void onCreate(SQLiteDatabase db){
        String createtable = "CREATE TABLE" + tblname + "(" + COL1 + " INTEGER PRIMARY KEY " + COL2 + " TEXT" + ")";
        db.execSQL(createtable);
    }

    //upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion){
        //drop table
        db.execSQL("DROP TABLE IF EXISTS " + tblname);

        //re-create table
        onCreate(db);
    }
}

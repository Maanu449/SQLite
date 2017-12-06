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

    //adding new entry
    public void addEntry(Names names_obj){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL2, names_obj.getname());

        db.insert(tblname,null, values);
        db.close();
    }

    //getting all entries
    public List<Names> GetAllEntries(){
        List<Names> listobj = new ArrayList<Names>();
        String syntax = "SELECT * FROM" + tblname;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor objofcursor = db.rawQuery(syntax,null);

        if(objofcursor.moveToFirst()){
            do{
                Names namesobj = new Names();
                namesobj.setId(Integer.parseInt(objofcursor.getString(0)));
                namesobj.setName(objofcursor.getString(1));

                listobj.add(namesobj);
            } while(objofcursor.moveToNext());
        }

        return listobj;

    }
}

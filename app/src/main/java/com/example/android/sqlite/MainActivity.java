package com.example.android.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    sqlOperations1 db = new sqlOperations1(this);
    Log.d("List" , "Listing");

    db.addEntry(new Names("ABC"));

    List<Names> list = db.GetAllEntries();
    for(Names nm: list){
        String display = "Roll no. : " + nm.getId() + " Name: " + nm.getname();
    }

    Log.d("Entry " + display);

}

package com.example.android.sqlite;

public class Names {
    int id;
    String name;

    public Names(){}

    public Names(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Names(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getname(){
        return name;
    }
} 

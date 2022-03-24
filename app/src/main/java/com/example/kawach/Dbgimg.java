package com.example.kawach;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dbgimg extends SQLiteOpenHelper {
    private static final String DBNAME="student.db";
    private static final String TABLE_NAME="gimg";
    private static final int VER=1;
    public Dbgimg(@Nullable Context context) {
        super(context,DBNAME , null, VER);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querry ="create table "+TABLE_NAME+"(id integer primary key, avatar blob)";
            sqLiteDatabase.execSQL(querry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String q="drop table if exists "+TABLE_NAME+  "";
        sqLiteDatabase.execSQL(q);
    }
}

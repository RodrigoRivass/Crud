package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE alumno(rut INTERGER PRIMARY KEY, Nombre TEXT, Direccion TEXT, com TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS almuno");
        db.execSQL("CREATE TABLE alumno (rut INTERGER PRIMARY KEY, Nombre TEXT, Direccion TEXT, com TEXT)");
    }

}

package com.louagin.apartmentscapes.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 6;
    public static final String DATABASE_NAME = "gameDb";
    public static final String TABLE_NAME = "gamePlay";

    public static final String ID_ROOM = "id_room";
    public static final String IS_OPEN = "is_open";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" +
                ID_ROOM + " integer primary key, " +
                IS_OPEN + " integer NOT NULL DEFAULT 0);");
//        db.execSQL("create table " + TABLE_NAME + "(" + ID_ROOM + " integer primary key autoincrement, "
//                + IS_OPEN + " text, "
//                + MAIL_ID + " text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);

        onCreate(db);
    }
}

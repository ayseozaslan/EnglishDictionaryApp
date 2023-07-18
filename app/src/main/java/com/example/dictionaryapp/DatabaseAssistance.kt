package com.example.dictionaryapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseAssistance(mContext:Context) :SQLiteOpenHelper(mContext,"sozlukk.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS\"words\" (\n" +
                "\t\"word_id\"\tINTEGER,\n" +
                "\t\"englısh\"\tTEXT,\n" +
                "\t\"turkısh\"\tTEXT,\n" +
                "\t\"word_id\" PRIMARY KEY AUTOINCREMENT\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(" DROP TABLE IF EXISTS words")
        onCreate(db)
    }
}
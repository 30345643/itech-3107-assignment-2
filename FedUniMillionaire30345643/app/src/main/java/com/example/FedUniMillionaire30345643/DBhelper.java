package com.example.FedUniMillionaire30345643;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context,"Score.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Score(name INTEGER primary key AUTOINCREMENT, n TEXT, score INTEGER,date TEXT ,difficult TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Score");
    }

    public Boolean InsertInDB(String name, int score, String date,String d) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("n", name);
        cont.put("score", score);
        cont.put("date", date);
        cont.put("difficult",d);
        long result = db.insert("Score", null, cont);
        if (result == -1) {
            return false;
        } else return true;
    }

    public Boolean deleteDB(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Score where date=?", new String[]{date});
        if (cursor.getCount() > 0) {
            long result = db.delete("Score", "date=?", new String[]{date});
            if (result == -1) {
                return false;
            } else return true;
        } else return false;
    }
    public Cursor getdataDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Score", null);
        return cursor;
    }
}

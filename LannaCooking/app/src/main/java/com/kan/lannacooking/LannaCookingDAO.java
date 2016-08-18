package com.kan.lannacooking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Kanty on 16/8/2559.
 */
public class LannaCookingDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public LannaCookingDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public ArrayList<String> getAllCooking(){
        ArrayList<String> Cooking = new ArrayList<String>();
        Cursor cursor = database.rawQuery("SELECT * FROM Cooking",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Cooking.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return Cooking;
    }
}

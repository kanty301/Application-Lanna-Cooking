package com.kan.lannacookingv3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Kanty on 20/8/2559.
 */
public class CookingDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public CookingDAO(Context context){
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public ArrayList<Cooking>findAll(){
        ArrayList<Cooking> cookings = new ArrayList<>();
        String sqlText  = "SELECT * FROM cooking ORDER BY id DESC;";
        Cursor cursor = database.rawQuery(sqlText,null);
        cursor.moveToFirst();
        Cooking cooking;
        while (!cursor.isAfterLast()){
            cooking = new Cooking();
            cooking.setId(cursor.getString(0));
            cooking.setName(cursor.getString(1));
            cooking.setItem(cursor.getString(2));
            cooking.setStep(cursor.getString(3));
            cooking.setTrick(cursor.getString(4));
            cooking.setImg(cursor.getString(5));

            cookings.add(cooking);
            cursor.moveToNext();
        }
        return cookings;
    }

}





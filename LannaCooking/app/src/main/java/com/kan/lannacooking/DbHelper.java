package com.kan.lannacooking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kanty on 16/8/2559.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String databaseName="lannacooking.sqlite";
    private static final int databaseVersion = 1;
    Context myContext;

    private static  final  String tableCreateSQL = "CREATE TABLE Cooking("+
            "c_Id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "c_Name TEXT,"+
            "c_item TEXT,"+
            "c_step TEXT,"+
            "c_tips TEXT"+
            ");";

    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tableCreateSQL);
        String insertData1 = "INSERT INTO Cooking (c_Name) VALUES ('จอผักกาด');";
        sqLiteDatabase.execSQL(insertData1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

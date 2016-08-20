package com.kan.lannacookingv3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kanty on 20/8/2559.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "LannaCooking.sqlte";
    private static final int databaseVersion = 2;
    private Context myContext;



    public DbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);

        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //ทำตาราง cooking
        String SQLText = "CREATE TABLE cooking ("+
                "id TEXT PRIMARY KEY," +
                "name TEXT," +
                "item TEXT," +
                "step TEXT," +
                "trick TEXT," +
                "img TEXT);";
        db.execSQL(SQLText);

        SQLText = "INSERT INTO cooking (id, name, item, step,trick, img)" +
                "VALUES ('001', 'จอผักกาด', 'ผักกาด\nน้ำมันพืช', 'X\nX\nX', 'XXX','xxx');";
        db.execSQL(SQLText);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

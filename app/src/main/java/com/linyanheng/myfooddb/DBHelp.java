package com.linyanheng.myfooddb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by linyanheng on 2017/12/13.
 */

public class DBHelp extends SQLiteOpenHelper {
   static SQLiteDatabase database;
   static String DB_NAME = "food.db";
   static int version = 1 ;

    public DBHelp(Context context, String DB_NAME,SQLiteDatabase.CursorFactory factory,int version)
    {

        super(context,DB_NAME,factory,version);
    }

    public static SQLiteDatabase getDatabse(Context context)
    {
        if(database == null || !database.isOpen())
        {
            database = new DBHelp(context,DB_NAME,null,version).getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(FOODDAO.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         onCreate(db);
    }
}

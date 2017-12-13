package com.linyanheng.myfooddb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyanheng on 2017/12/13.
 */

public class FOODDAO {
   // static String CREATE_TABLE;
    static String TABLE_NAME = "food";

    static String id_column = "_id";
    static String food_column = "food" ;//食物類別
    static String cal_column = "cal" ;//卡路里

    private SQLiteDatabase db;

    //create SQL語法
    static String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME +" (" +
            id_column + " Integer primary key autoincrement, " +
            food_column + " text ,"+
            cal_column + " text )";

    public FOODDAO(Context context )
    {
        db = DBHelp.getDatabse(context);
    }

    public Food insert(Food food)
    {
        ContentValues cv = new ContentValues();
        cv.put(id_column,food.getId());
        cv.put(food_column,food.getFood());
        cv.put(cal_column,food.getCal());
        long id = db.insert(TABLE_NAME, null, cv);
        food.setId(id);
        return food;
    }

    public boolean delete(long id)
    {
        String where = id_column + " = "+id;
        return    db.delete(TABLE_NAME,where,null)>0;

    }

    public List<Food> getAll()
    {
        List<Food> foods = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,null);
        while (cursor.moveToNext())
        {
            foods.add(getRecord(cursor));
        }
        return  foods;

    }

    private Food getRecord(Cursor cursor) {
            Food food = new Food();
            food.setId(cursor.getLong(0));
            food.setFood(cursor.getString(cursor.getColumnIndex(food_column)));
            food.setCal(cursor.getString(cursor.getColumnIndex(cal_column)));
            return food;
    }

    public void sample()
    {
        Food food1 = new Food(1,"哈密瓜","100");
        Food food2 = new Food(2,"西瓜","95");
        Food food3 = new Food(3,"香蕉","56");

        insert(food1);
        insert(food2);
        insert(food3);

    }


}

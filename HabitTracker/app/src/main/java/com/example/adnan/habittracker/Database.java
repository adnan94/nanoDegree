package com.example.adnan.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Adnan on 8/22/2016.
 */
public class Database extends SQLiteOpenHelper {
    public static final String Database_Name = "Habit.db";
    public static final String Table_Name = "habits";
    public static final int Database_Version = 1;
    public static ArrayList<Habits> arrayList;

    public Database(Context context) {

        super(context, Database_Name,null, Database_Version);
        arrayList = new ArrayList<>();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table = "CREATE TABLE IF NOT EXISTS "+Table_Name+"(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , title TEXT , description TEXT)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public ArrayList<Habits> retrive() {
        arrayList.clear();
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = ("SELECT * FROM "+Table_Name);
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            int id =Integer.parseInt(c.getString(0));
            String title = c.getString(1);
            String description = c.getString(2);
            arrayList.add(new Habits(title,description,id));

        }
        db.close();
        return arrayList;
    }

    public void insertProduct(Habits habits) {
        ContentValues content = new ContentValues();
        //    content.put("studentID",0);
        content.put("title", habits.getTitle());
        content.put("description", habits.getDescription());


        SQLiteDatabase db = getWritableDatabase();
        db.insert(Table_Name, null, content);
        db.close();
    }
    public void update(String title, String desc,int id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("title",title );
        c.put("description", desc);
        db.update(Table_Name, c,  "ID=?", new String[]{String.valueOf(id)});
        db.update(Table_Name, c,  "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteProduct(int id) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+Table_Name+" WHERE ID =" + id + ";");
    }
}

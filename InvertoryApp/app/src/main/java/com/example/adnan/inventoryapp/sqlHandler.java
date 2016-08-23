package com.example.adnan.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Adnan on 8/21/2016.
 */
public class sqlHandler extends SQLiteOpenHelper {
    public static final String Database_Name = "Products.db";
    public static final String Table_Name = "products";
    public static final String Table_Name2 = "sales";

    //    public static final String Coloumn_ID = "_id";
//    public static final String Coloumn_Products = "products";
    public static final int Database_Version = 5;
    public static ArrayList<signatureProducts> arrayList;
    public static ArrayList<signatureSales> arrayList2;

    adaptorProducts adaptor;

    public sqlHandler(Context context) {

        super(context, Database_Name, null, Database_Version);
        arrayList = new ArrayList<>();
        arrayList2 = new ArrayList<>();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table = "CREATE TABLE IF NOT EXISTS " + Table_Name + "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , name TEXT , quantity INTEGER , price INTEGER )";
        db.execSQL(table);

        String table2 = "CREATE TABLE IF NOT EXISTS " + Table_Name2 + "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , name TEXT , quantity INTEGER , price INTEGER ,sale INTEGER)";
        db.execSQL(table2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sales");
        db.execSQL("DROP TABLE IF EXISTS products");

        onCreate(db);
    }

    public void insertProduct(signatureProducts s) {
        ContentValues content = new ContentValues();

        content.put("name", s.getName());
        content.put("quantity", s.getQuantity());
        content.put("price", s.getPrice());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("products", null, content);
        db.close();
    }


    //
    public void deleteProduct(int id, String tableName) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + tableName + " WHERE ID =" + id + ";");

        db.close();
    }


    public void updateValue(signatureProducts signatureProducts) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name", signatureProducts.getName());
        content.put("quantity", signatureProducts.getQuantity());
        content.put("price", signatureProducts.getPrice());


        db.update(Table_Name, content, "ID=?", new String[]{String.valueOf(signatureProducts.getId())});
        db.close();

    }

    public ArrayList<signatureProducts> retrive() {
        arrayList.clear();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + Table_Name;
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            int id = Integer.parseInt(c.getString(0));
            String name = c.getString(1);
            int quantity = c.getInt(2);
            int price = c.getInt(3);
            arrayList.add(new signatureProducts(name, quantity, id, price));
        }
        db.close();
        return arrayList;
    }
    public void insertSales(signatureSales s) {
        ContentValues content = new ContentValues();

        content.put("name", s.getName());
        content.put("quantity", s.getQuantity());
        content.put("price", s.getPrice());
        content.put("sale", s.getSales());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("sales", null, content);
        db.close();
    }

    public ArrayList<signatureSales> retriveSales() {
        arrayList2.clear();
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+Table_Name2;
        Cursor c = db.rawQuery(query, null);
        while (c.moveToNext()) {
            int id = Integer.parseInt(c.getString(0));
            String name = c.getString(1);
            int quantity = c.getInt(2);
            int price = c.getInt(3);
            int sales = c.getInt(4);

         


            arrayList2.add(new signatureSales(name, sales, quantity, price, id));

        }
        db.close();
        return arrayList2;
    }
}

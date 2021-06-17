package com.yetngo289.recyclerviewtest;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "testproduct";
    private final static String TABLE_NAME = "product";
    private final static String MASP = "masp";
    private final static String TENSP = "tensp";
    private final static String MOTA = "mota";
    private final static String GIATIEN = "giatien";

    private String createTable = "create table product (masp TEXT, tensp TEXT, mota TEXT, giatien TEXT)";
    private String deleteTable = "drop table if exists product";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(deleteTable);
        sqLiteDatabase.execSQL(createTable);
    }

    public void insertData(String masp, String tensp,String mota,String giatien) {
        String sql = "insert into " + TABLE_NAME + " values ('" + masp + "','" + tensp + "','" + mota + "','" + giatien + "')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateData(String masp, String tensp,String mota,String giatien) {
        String sql = "update " + TABLE_NAME + " set "+ TENSP+"='" + tensp +"', "+ MOTA+"='"+mota+"',"+ GIATIEN+"='"+giatien+ "' where " + MASP + "='" + masp + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public void deleteData(String masp) {
        String sql = "delete from " + TABLE_NAME + " where " + MASP + "='" + masp + "'";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public ArrayList<Product> getProducts(){
        ArrayList<Product> listProductname = new ArrayList<>();
        String sql="select * from "+TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            listProductname.add(new Product(cursor.getString(cursor.getColumnIndexOrThrow(MASP))
            ,cursor.getString(cursor.getColumnIndexOrThrow(TENSP))
            ,cursor.getString(cursor.getColumnIndexOrThrow(MOTA))
            ,cursor.getString(cursor.getColumnIndexOrThrow(GIATIEN))));
        }
        cursor.close();
        return listProductname;
    }
}


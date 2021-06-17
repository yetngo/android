package com.yetngo289.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="testproduct";
    private final static String TABLE_NAME="product";
    private final static String PRODUCT_NAME="product_name";
    private final static String PRODUCT_CODE="product_code";
    private String createTable="create table product(product_name TEXT, product_code TEXT)";
    private String deleteTable="drop table if exists product";

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, nul;);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(deleteTable);
        db.execSQL(createTable);
    }

    public void insertData(String name, String code){
        String sql="insert into "+TABLE_NAME+" values ('"+name+"','"+code+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateData(String name, String code){
        String sql="update "+TABLE_NAME+" set name='"+name+"' where " +PRODUCT_CODE+"='"+code+"'";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    public void deleteData(String code){
        String sql="delete from "+TABLE_NAME+" where " +PRODUCT_CODE+"='"+code+"'";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    public ArrayList<String> getProduct(){
        ArrayList<String> productName=new ArrayList<>();
        String sql="select * from "+TABLE_NAME;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            productName.add(cursor.getS)
        }
    }
}

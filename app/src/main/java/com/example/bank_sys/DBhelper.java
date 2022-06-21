package com.example.bank_sys;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DataName="AlyaaDB";
    private static final String tableName1="customerAcc";
    private static final String col_1="firstname";
    private static final String col_2="lastname";
    private static final String col_3="mail";
    private static final String col_4="passw";
    private static final String col_5="amount";

    public DBhelper(@Nullable Context context) {
        super(context, DataName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL("CREATE TABLE IF NOT EXISTS "+tableName1+"(firstname TEXT,lastname TEXT,mail TEXT PRIMARY KEY,passw TEXT,amount INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+tableName1);
        onCreate(db);

    }
    public boolean registeruser(String firstname, String lastname,String mail,String passw, int amount){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put(col_1,firstname);
        con.put(col_2,lastname);
        con.put(col_3,mail);
        con.put(col_4,passw);
        con.put(col_5,amount);
        long result=db.insert(tableName1,null,con);
        if(result==-1){
            return false;
        }
        else
            return true;

    }
    public boolean checkuse(String user,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from "+tableName1+" where "+col_3+" =? and "+col_4+"=? ",new String[] {user,pass});

        int count=cursor.getCount();
        db.close();
        cursor.close();
        if(count>0)
            return true;
        else
            return false;
    }
    public boolean checkuserfound(String user){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor =db.rawQuery("select * from "+tableName1+" where "+col_3+" =? ",new String[] {user});
        int count=cursor.getCount();
        db.close();
        cursor.close();
        if(count>0)
            return true;
        else
            return false;
    }
    public Boolean updatepass(String user,String pass){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new  ContentValues();
        contentValues.put(col_4,pass);
        Cursor cursor=DB.rawQuery("select * from "+tableName1+" where "+col_3+"=? ",new String[] {user});
        if(cursor.getCount() >0){
            long result = DB.update(tableName1, contentValues, col_3+"=? ", new String[]{user});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public Boolean updateamount(String user,int amount){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new  ContentValues();
        contentValues.put(col_5,amount);
        Cursor cursor=DB.rawQuery("select * from "+tableName1+" where "+col_3+"=? ",new String[] {user});
        if(cursor.getCount() >0){
            long result = DB.update(tableName1, contentValues, col_3+"=? ", new String[]{user});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public Boolean deleteuser(String user){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from "+tableName1+" where "+ col_3+"=? ",new String[] {user});
        if(cursor.getCount() >0){
            long result = DB.delete(tableName1, col_3+"=? ", new String[]{user});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    public String getamount(String user){
        SQLiteDatabase DB=this.getReadableDatabase();
        Cursor cursor=DB.rawQuery("select "+col_5+" from "+tableName1+" where "+ col_3+"=? " ,new String[] {user});
        String res= cursor.getString(4);
        return res;

    }
}

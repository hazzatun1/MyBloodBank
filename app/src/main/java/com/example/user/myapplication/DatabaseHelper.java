package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
        public static final String DATABASE_NAME ="bloodbank.db";
        public static final String TABLE_user ="registeruser";
        public static final String COL_1 ="ID";
        public static final String COL_2 ="username";
        public static final String COL_3 ="password";
        public static final String COL_4 ="mobile";
        public static final String COL_5 ="bloodGroup";
    public static final String COL_6 ="address";

        public static final String TABLE_donor ="registerdonor";
        public static final String COL_d1 ="ID";
        public static final String COL_d2 ="username";
        public static final String COL_d3 ="password";
        public static final String COL_d4 ="mobile";
        public static final String COL_d5 ="bloodGroup";
    public static final String COL_d6 ="address";

    public static final String TABLE_blood ="blood_management";
    public static final String COL_dd1 ="ID";
    public static final String COL_dd2 ="value_per_bag";
    public static final String COL_dd3 ="ifPaid";
    public static final String COL_dd4 ="seeker_time_range";


        public DatabaseHelper(@Nullable Context context)
        {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE registeruser " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT, mobile TEXT, bloodGroup TEXT, address TEXT)");
            sqLiteDatabase.execSQL("CREATE TABLE registerdonor " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT, mobile TEXT, bloodGroup TEXT, address TEXT)");
            sqLiteDatabase.execSQL("CREATE TABLE blood_management " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, value_per_bag TEXT, ifPaid TEXT, seeker_time_range TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_user);
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_donor);
            onCreate(sqLiteDatabase);
        }

        public boolean addUser(String user, String password,String contact,String bloodGroup,String address ){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username",user);
            contentValues.put("password",password);
            contentValues.put("mobile",contact);
            contentValues.put("bloodGroup",bloodGroup);
            contentValues.put("address",address);
            db.insert("registeruser",null,contentValues);
            db.close();
            return true;
        }

    public boolean addDonor(String user, String password,String contact,String bloodGroup,String address ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        contentValues.put("mobile",contact);
        contentValues.put("bloodGroup",bloodGroup);
        contentValues.put("address",address);
        db.insert("registerdonor",null,contentValues);
        db.close();
        return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_user,null);
        return res;
    }

    public long addBlood(String vpb){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("value_per_bag",vpb);

        long res = db.insert("blood_management",null,contentValues);
        db.close();
        return  res;
    }
    public long addBlood2(String ip, String str){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ifPaid",ip);
        contentValues.put("seeker_time_range", str);
        long res = db.insert("blood_management",null,contentValues);
        db.close();
        return  res;
    }

    public boolean check_Login(String u_name, String u_pwd) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = " SELECT * FROM TABLE_user WHERE COL_2 = '" + u_name + "' AND COL_3 = '" + u_pwd + "' ";

        Cursor c = db.rawQuery(select, null);

        if (c.moveToFirst())
            return true;

else
        return false;
    }
    public boolean checkUser(String username, String password){
            String[] columns = { COL_1 };
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
            String[] selectionArgs = { username, password };
            Cursor cursor = db.query(TABLE_user,columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            if(count>0)
                return  true;
            else
                return  false;
        }

        public boolean checkDonor(String username, String password){
            String[] columns = { COL_d1 };
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_d2 + "=?" + " and " + COL_d3 + "=?";
            String[] selectionArgs = { username, password };
            Cursor cursor = db.query(TABLE_donor,columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            if(count>0)
                return  true;
            else
                return  false;
        }


}



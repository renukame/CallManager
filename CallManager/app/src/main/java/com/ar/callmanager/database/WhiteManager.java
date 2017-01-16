package com.ar.callmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ar.callmanager.model.WhiteDetails;

import java.util.ArrayList;
import java.util.List;

import static com.ar.callmanager.database.ContactContract.White.COLUMN_NAME;
import static com.ar.callmanager.database.ContactContract.White.COLUMN_NUMBER;
import static com.ar.callmanager.database.ContactContract.White.CREATE_TABLE;
import static com.ar.callmanager.database.ContactContract.White.DROP_TABLE;
import static com.ar.callmanager.database.ContactContract.White.SELECT_QUERY;
import static com.ar.callmanager.database.ContactContract.White.TABLE_NAME;

public class WhiteManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private List<WhiteDetails> whiteList = new ArrayList<>();
    public static final String DATABASE_NAME = "WhiteManager.db";
    public WhiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void writeWhiteData(String name,String number){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_NUMBER,number);
        db.insert(TABLE_NAME,null,cv);
    }

    public List readWhiteData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String number = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NUMBER));
            WhiteDetails whiteDetails = new WhiteDetails(name,number);
            whiteList.add(whiteDetails);
        }
        cursor.close();
        return whiteList;
    }
}

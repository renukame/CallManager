package com.ar.callmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ar.callmanager.model.BlackDetails;

import java.util.ArrayList;
import java.util.List;

import static com.ar.callmanager.database.ContactContract.Black.COLUMN_NAME;
import static com.ar.callmanager.database.ContactContract.Black.COLUMN_NUMBER;
import static com.ar.callmanager.database.ContactContract.Black.CREATE_TABLE;
import static com.ar.callmanager.database.ContactContract.Black.DROP_TABLE;
import static com.ar.callmanager.database.ContactContract.Black.SELECT_QUERY;
import static com.ar.callmanager.database.ContactContract.Black.TABLE_NAME;

/**
 * Created by Renuka on 16-01-2017.
 */

public class BlackManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private List<BlackDetails> blackList = new ArrayList<>();
    public static final String DATABASE_NAME = "BlackManager.db";

    public BlackManager(Context context) {
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

    public void writeBlackData(String name, String number) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_NUMBER, number);
        db.insert(TABLE_NAME, null, cv);
    }

    public List readBlackData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String number = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NUMBER));
            BlackDetails blackDetails = new BlackDetails(name, number);
            blackList.add(blackDetails);
        }
        cursor.close();

        return blackList;
    }
}


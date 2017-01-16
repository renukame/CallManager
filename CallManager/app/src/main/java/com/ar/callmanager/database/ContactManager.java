package com.ar.callmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ar.callmanager.model.ContactDetails;

import java.util.ArrayList;
import java.util.List;

import static com.ar.callmanager.database.ContactContract.Contact.COLUMN_NAME;
import static com.ar.callmanager.database.ContactContract.Contact.COLUMN_NUMBER;
import static com.ar.callmanager.database.ContactContract.Contact.CREATE_TABLE;
import static com.ar.callmanager.database.ContactContract.Contact.DROP_TABLE;
import static com.ar.callmanager.database.ContactContract.Contact.TABLE_NAME;

public class ContactManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private final String TAG = ContactManager.class.getSimpleName();
    public static final String DATABASE_NAME = "ContactManager.db";
    private List<ContactDetails> contactList = new ArrayList<>();

    public ContactManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean writeContacts(String number, String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NUMBER, number);
        cv.put(COLUMN_NAME, name);
        sqLiteDatabase.insert(TABLE_NAME, null, cv);
        Log.d(TAG, "Data Inserted successfully");
        return true;
    }

    public List<ContactDetails> readContacts() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor contactData = db.rawQuery("select * from " + TABLE_NAME , null);

        while (contactData.moveToNext()) {
            ContactDetails contactDetails = new ContactDetails(contactData.getString(contactData.getColumnIndex(COLUMN_NUMBER)), contactData.getString(contactData.getColumnIndex(COLUMN_NAME)));
            contactList.add(contactDetails);
        }
        contactData.close();
        return contactList;
    }
}

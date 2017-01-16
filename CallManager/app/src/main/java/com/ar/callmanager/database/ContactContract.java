package com.ar.callmanager.database;

/**
 * Created by Renuka on 16-01-2017.
 */

public class ContactContract {


    public static class Contact{
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NUMBER = "number";
        public static final String COLUMN_NAME = "name";
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_NUMBER + " INTEGER ," + COLUMN_NAME + " TEXT )";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class White{
        public static final String TABLE_NAME = "white";
        public static final String COLUMN_NUMBER = "number";
        public static final String COLUMN_NAME = "name";
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_NUMBER + " INTEGER ," + COLUMN_NAME + " TEXT )";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
    }

    public static class Black{
        public static final String TABLE_NAME = "black";
        public static final String COLUMN_NUMBER = "number";
        public static final String COLUMN_NAME = "name";
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_NUMBER + " INTEGER ," + COLUMN_NAME + " TEXT )";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;
    }
}

package com.example.deepak.inventoryproductapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.deepak.inventoryproductapp.ProductProvider;

public class DbHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = DbHelper.class.getName();

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    /** Name of the database file */
    private static final String DATABASE_NAME = "shelter.db";

    // Constants to construct SQLite statements
    private static final String INTEGER = " INTEGER";
    private static final String TEXT = " TEXT";
    private static final String NOT_NULL = " NOT NULL";
    private static final String PRIMARY_KEY_AUTOINCREMENT = " PRIMARY KEY AUTOINCREMENT";
    private static final String DEFAULT = " DEFAULT";
    private static final String DEFAULT_VALUE = " 0";
    private static final String COMMA_SEP = ", ";
    private static final String BLOB_TYPE = " BLOB";
    // Constants for SQLite statements themselves;
    private static final String SQL_CREATE_PRODUTS_TABLE =

            "CREATE TABLE " + ProductProvider.ProductEntry.TABLE_NAME  + " (" +
                    ProductProvider.ProductEntry._ID + INTEGER + PRIMARY_KEY_AUTOINCREMENT + COMMA_SEP +
                    ProductProvider.ProductEntry.COLUMN_PRODUCT_NAME + TEXT + NOT_NULL + COMMA_SEP +
                    ProductProvider.ProductEntry.COLUMN_PRODUCT_QUANTITY + INTEGER + COMMA_SEP +
                    ProductProvider.ProductEntry.COLUMN_PRODUCT_PRICE + INTEGER + NOT_NULL + COMMA_SEP +
                    ProductProvider.ProductEntry.COLUMN_PRODUCT_IMAGE + TEXT +
                    ");";


    /**
     * Constructs a new instance of {@link DbHelper}.
     *
     * @param context of the app
     */
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "SQL STATEMENT TO CREATE PRODUCTS TABLE: " + SQL_CREATE_PRODUTS_TABLE);
        db.execSQL(SQL_CREATE_PRODUTS_TABLE);
    }

    /**
     * Called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here
        if(oldVersion!=newVersion){
            db.execSQL(SQL_CREATE_PRODUTS_TABLE);
            onCreate(db);
        }
    }


}


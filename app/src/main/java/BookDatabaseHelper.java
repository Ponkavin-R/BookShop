package com.example.booksmyshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BookStore2.db";
    private static final int DATABASE_VERSION = 1;

    // Define table and column names
    private static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";

    // Create table query
    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_PRICE + " TEXT)";

    public BookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add a new book
    public long addBook(String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // Method to update an existing book
    public int updateBook(String id, String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
    }

    // Method to delete a book
    public int deleteBook(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{id});
    }

    // Method to get all books
    public Cursor getAllBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}

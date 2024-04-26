package com.example.booksmyshop;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BookMy.db";
    private static final int DATABASE_VERSION = 1;

    // Define table and column names
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_PASSWORD = "password";

    // Create table query
    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_MOBILE + " TEXT," +
            COLUMN_PASSWORD + " TEXT)";

    public DatabaseHelper(Context context) {
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

    // Method to add a new user
    public long addUser(String name, String email, String mobile, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_MOBILE, mobile);
        values.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // Checking if user exists in the database
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Define the query to check if the user exists
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";

        // Define the selection arguments
        String[] selectionArgs = {email, password};

        // Execute the query
        Cursor cursor = db.rawQuery(query, selectionArgs);

        // Check if the cursor has any rows
        boolean exists = cursor.moveToFirst();

        // Close the cursor and database
        cursor.close();
        db.close();

        return exists;
    }
}

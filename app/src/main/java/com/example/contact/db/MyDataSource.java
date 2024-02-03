package com.example.contact.db;

// MyDataSource.java
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.contact.R;
import com.example.contact.model.User;


import java.util.ArrayList;
import java.util.List;

public class MyDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public MyDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertData(String name) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, name);
        database.insert(DbHelper.TABLE_NAME, null, values);
    }

    public List<User> getAllData() {
        List<User> dataList = new ArrayList<>();

        Cursor cursor = database.query(
                DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NAME));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NUMBER));
                User user = new User(id, name, number, R.drawable.baseline_person_24);
                dataList.add(user);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return dataList;
    }

    public void updateData(long id, String newName) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_NAME, newName);
        String whereClause = DbHelper.COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(id)};
        database.update(DbHelper.TABLE_NAME, values, whereClause, whereArgs);
    }

    public void deleteData(long id) {
        String whereClause = DbHelper.COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(id)};
        database.delete(DbHelper.TABLE_NAME, whereClause, whereArgs);
    }
}


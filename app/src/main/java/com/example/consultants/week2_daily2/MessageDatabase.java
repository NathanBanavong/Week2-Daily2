package com.example.consultants.week2_daily2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.consultants.week2_daily2.Model.UserMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase extends SQLiteOpenHelper {
    public MessageDatabase(Context context) {
        super(context, MessageContract.NAME, null, MessageContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saveString(UserMessage message) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MessageContract.FeedEntry.COL_ID, message.getMessage());
        contentValues.put(MessageContract.FeedEntry.COL_MESSAGE, message.getMessage());

        long rowID = database.insert(MessageContract.FeedEntry.TABLE_NAME, null, contentValues);

        return rowID;
    }


    //    Calls this function in the MainActivity -> manroop put this in for - loop => DONT DO THIS!!!
    public List<String> getListStrings() {
        SQLiteDatabase database = getWritableDatabase();

        List<String> stringList = new ArrayList<>();

        Cursor cursor = database.rawQuery(MessageContract.CREATE_TABLE, null);

        //input each input stringList -> array
//        if (cursor.moveToFirst()) {
//            do {
//                UserMessage message = new UserMessage(cursor.getString(cursor.getColumnIndex(MessageContract.FeedEntry.COL_MESSAGE)));
//            } while (cursor.moveToNext());
//        }

        database.execSQL(MessageContract.CREATE_TABLE);

        return null;
    }

    public List<UserMessage> leDisplayDB() {
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(MessageContract.GET_ALL, null);

        ArrayList<UserMessage> DBtoArray = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                UserMessage message = new UserMessage(cursor.getString(cursor.getColumnIndex(MessageContract.FeedEntry.COL_MESSAGE)),
                        cursor.getString(cursor.getColumnIndex(MessageContract.FeedEntry.COL_ID)));
                DBtoArray.add(message);
            } while (cursor.moveToNext());
        }

        database.execSQL(MessageContract.GET_ALL);

        return DBtoArray;
    }


}


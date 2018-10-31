package com.example.consultants.week2_daily2;

import android.provider.BaseColumns;

public class MessageContract {

    public static final String NAME = "Photograph.db";
    public static int VERSION = 1;

//    IF ADD PICTURE AS PART -> NEED TO ADD AS VARIABLE
//    Create, Update, Delete, Read (Get_All)
//    public static final String CREATE_TABLE = "CREATE TABLE " +
//            FeedEntry.TABLE_NAME + "{" +
//            FeedEntry.COL_MESSAGE + " Text," +
//            FeedEntry.COL_IMAGE + "}";
//    public static final String UPDATE_TABLE = "UPDATE TABLE " +
//            FeedEntry.TABLE_NAME + "{" +
//            FeedEntry.COL_MESSAGE + " Text," +
//            FeedEntry.COL_IMAGE + "}";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            FeedEntry.TABLE_NAME + "(" +
            FeedEntry.COL_ID + " Text," +
            FeedEntry.COL_MESSAGE + " Text)";


    public static final String UPDATE_TABLE = "UPDATE TABLE " +
            FeedEntry.TABLE_NAME + "(" +
            FeedEntry.COL_ID + " Text," +
            FeedEntry.COL_MESSAGE + " Text)";

    public static final String DELETE_TABLE = "DROP TABLE " +
            FeedEntry.TABLE_NAME;

    public static final String GET_ALL = "SELECT * FROM " + FeedEntry.TABLE_NAME;

//    variables in Table -> user input string
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Message";
        public static final String COL_ID = "ID";
        public static final String COL_MESSAGE = "UserInput";
//        add blob image
        public static final String COL_IMAGE = "picBlob";
    }



}

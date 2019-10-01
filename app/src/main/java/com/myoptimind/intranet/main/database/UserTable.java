package com.myoptimind.intranet.main.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myoptimind.intranet.main.handler.UserDetails;

import org.json.JSONObject;

public class UserTable extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();

    private static final String TABLE_NAME = "users";
    private static final String COL_ID     = "id";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_LAST_NAME =  "last_name";
    private static final String COL_POSITION = "position";
    private static final String COL_HOME_ADDRESS = "home_address";
    private static final String COL_HOME_NUMBER = "home_number";
    private static final String COL_MOBILE_NUMBER = "mobile_number";


    public UserTable(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_FIRST_NAME + " TEXT," +
                COL_LAST_NAME + " TEXT," +
                COL_POSITION + " TEXT," +
                COL_HOME_ADDRESS + " TEXT," +
                COL_HOME_NUMBER + " TEXT," +
                COL_MOBILE_NUMBER + " TEXT"
                 + ")";

        sqLiteDatabase.execSQL(query);
    }

    public Boolean add(UserDetails userDetails){

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ID,userDetails.getUserId());
        contentValues.put(COL_FIRST_NAME,userDetails.getFirstName());
        contentValues.put(COL_LAST_NAME,userDetails.getLastName());
        contentValues.put(COL_POSITION,userDetails.getPosition());
        contentValues.put(COL_HOME_ADDRESS,userDetails.getHomeAddress());
        contentValues.put(COL_HOME_NUMBER,userDetails.getHomeNumber());
        contentValues.put(COL_MOBILE_NUMBER,userDetails.getMobileNumber());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(result == -1){
            return false;
        }
        return true;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public UserDetails getUserByid(String userId){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = " + userId;

        Cursor data = sqLiteDatabase.rawQuery(query,null);

        Log.i(TAG,query);

        if(data.moveToFirst());

        UserDetails userDetails = new UserDetails();

        userDetails.setUserId(data.getString(data.getColumnIndex(COL_ID)));
        userDetails.setFirstName(data.getString(data.getColumnIndex(COL_FIRST_NAME)));
        userDetails.setLastName(data.getString(data.getColumnIndex(COL_LAST_NAME)));
        userDetails.setPosition(data.getString(data.getColumnIndex(COL_POSITION)));
        userDetails.setHomeAddress(data.getString(data.getColumnIndex(COL_HOME_ADDRESS)));
        userDetails.setHomeNumber(data.getString(data.getColumnIndex(COL_HOME_NUMBER)));
        userDetails.setMobileNumber(data.getString(data.getColumnIndex(COL_MOBILE_NUMBER)));

        return userDetails;

    }
}

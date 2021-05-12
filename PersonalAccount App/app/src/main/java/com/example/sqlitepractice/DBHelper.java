package com.example.sqlitepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";

    //private HashMap hashMap;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
          "create table contacts " +
          "(id integer primary key, name text, phone text, email text, street text, place text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertContact(String name, String phone, String email, String street,String place){
        //Create and/or open a database that will be used for reading and writing.
        SQLiteDatabase db = this.getWritableDatabase();
        //This class is used to store a set of values that the ContentResolver can process.
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("place", place);
        db.insert("contacts",null,contentValues);
        return true;
    }
    //This interface provides random read-write
    // access to the result set returned by a database query
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor results = db.rawQuery("select * from contacts where id=" +id+ "",null);//Runs the provided SQL and returns a Cursor over the result set.
        return results;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db,CONTACTS_TABLE_NAME);//Static utility methods for dealing with databases and Cursors.
        return numRows;
    }
    public boolean updateContact(Integer id,String name,String phone, String email,
                                 String street,String place){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("place", place);
        db.update("contacts",contentValues,"id = ?", new String[] {
                Integer.toString(id)});
        return true;
    }
    public Integer deleteContact(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts", "id = ?",
                new String[] {Integer.toString(id)});
    }
    public ArrayList<String> getAllContacts(){
        ArrayList<String> arraylist = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from contacts",null);
        result.moveToFirst();

        while(result.isAfterLast() == false){   //Returns whether the cursor is pointing to the position after the last row.
        arraylist.add(result.getString(result.getColumnIndex(CONTACTS_COLUMN_NAME)));
        result.moveToNext();
        }
        return arraylist;
    }

    /*
    public String getContactsTableName(){
        String name;
        ArrayList<String> myList = new ArrayList<String>();
        SQLiteDatabase mydb = this.getReadableDatabase();
        Cursor cursor = mydb.rawQuery("select CONTACTS_COLUMN_NAME from contacts",null);
        cursor.moveToFirst();

        myList.add(cursor.getString(cursor.getColumnIndex(CONTACTS_COLUMN_NAME)));

       Iterator iterator = myList.iterator();

        if(iterator.hasNext()) {
             name = iterator.next().toString();
            textView.setText(name);
        }

        //name = myList.get();
        return name;
    }
    */
}

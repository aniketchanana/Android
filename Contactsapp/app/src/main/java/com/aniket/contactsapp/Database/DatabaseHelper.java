package com.aniket.contactsapp.Database;
import com.aniket.contactsapp.model.ContactInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int db_version = 1;
    private static final String databasee_name = "contacts_manager";
    private static final String table_contacts = "contacts";
    private static final String id = "id";
    private static final String name = "name";
    private static final String phone = "phone";
    private static final String email = "email";
    private static final String address = "address";

    public DatabaseHelper(Context context){
        super(context,databasee_name,null,db_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE contacts (id INTEGER PRIMARY kEY AUTOINCREMENT, name TEXT,phone TEXT,email TEXT,address TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts_manager");
    }

    public boolean addContact(ContactInfo contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(name,contact.getName());
        values.put(phone,contact.getPhone());
        values.put(email,contact.getEmail());
        values.put(address,contact.getAddress());

        long i =  db.insert(table_contacts,null,values);
        db.close();
        if(i == -1){
            return false;
        }else{
            return true;
        }
    }
    public ArrayList<ContactInfo> getAllContacts(){
        String query = "SELECT  * FROM " + table_contacts;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();

        ArrayList<ContactInfo> allContacts = new ArrayList<>();
        do{
            ContactInfo contact = new ContactInfo();
            contact.setName(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
            contact.setEmail(cursor.getString(3));
            contact.setAddress(cursor.getString(4));
            allContacts.add(contact);
        }while(cursor.moveToNext());

        return allContacts;
    }
    public void update(int id,String update_name,String update_email,String update_phone,String update_address){
        ContentValues values = new ContentValues();
        values.put(name,update_name);
        values.put(phone,update_email);
        values.put(email,update_phone);
        values.put(address,update_address);
        SQLiteDatabase db = getWritableDatabase();
        db.update(table_contacts,values,"id="+String.valueOf(id),null);
    }
    public void delete(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(table_contacts,"id="+String.valueOf(id),null);
    }
}

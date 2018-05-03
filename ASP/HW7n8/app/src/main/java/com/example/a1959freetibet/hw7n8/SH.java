package com.example.a1959freetibet.hw7n8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import android.content.ContentValues;


public class SH extends SQLiteOpenHelper {

    private static final int DB_VERSION = 16;
    private static final String DB_NAME = "BookDB";
    public static final String TABLE_BOOKS = "books";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_RATE = "rate";

    public SH(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "title TEXT, "+
                "author TEXT, " + "rate TEXT )";
        db.execSQL(CREATE_BOOK_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);
    }

    public void addBook(Book book){
        Log.d("addBook", book.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_RATE, book.getRate());

        db.insert(TABLE_BOOKS,
                null,
                values);
        db.close();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<Book>();

        String query = "SELECT * FROM " + TABLE_BOOKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setRate(cursor.getString(3));
                books.add(book);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", books.toString());
        return books;
    }


    public ArrayList<String> queryTitle() {
        ArrayList<String> t = new ArrayList<String>();
        String query = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                t.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        Log.d("queryTitle()", t.toString());
        return t;
    }


    public ArrayList<String> queryAuthor() {
        ArrayList<String> a = new ArrayList<String>();
        String query = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                a.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        Log.d("queryTitle()", a.toString());
        return a;
    }

    public ArrayList<String> queryRate() {
        ArrayList<String> r = new ArrayList<String>();
        String query = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                r.add(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        Log.d("queryTitle()", r.toString());
        return r;
    }

    public int updateBook(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());
        values.put("author", book.getAuthor());
        values.put("rate", book.getRate());

        int i = db.update(TABLE_BOOKS,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });
        db.close();
        Log.d("UpdateBook", book.toString());
        return i;
    }

    public void deleteBook(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_BOOKS, KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });

        db.close();
        Log.d("deleteBook", book.toString());
    }


    public String getBook(String title){
        String q = "SELECT * FROM " + TABLE_BOOKS + " WHERE title = '" + title + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(q, null);
        Book book = null;
        if(c.moveToFirst()){
            do{
                book = new Book();
                book.setTitle(c.getString(1));
                book.setAuthor(c.getString(2));
                book.setRate(c.getString(3));

            }while(c.moveToNext());
        }
        String i = "Title" + book.getTitle() + " Author " + book.getAuthor() + " Rate " + book.getRate();
        return  i;
    }

    public int getId(){
        String selectQuery = "SELECT id FROM books";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery(selectQuery,null);
        c.moveToFirst();
        int total = c.getCount();
        Log.d("Count book records", total + "");
        return total;
    }




}

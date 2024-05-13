package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "Todo";
    private final static int DB_VERSION = 8;

    public static final String TABLE_TODO = "TABLE_TODO";
    public static final String ID_COL = "Id";
    public static final String TODO_TITLE_COL = "Title";
    public static final String TODO_DATE_COL = "Date";
    public static final String TODO_Description_COL = "Description";

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTodoTableQuery = "CREATE TABLE " + TABLE_TODO + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TODO_TITLE_COL + " TEXT,"
                + TODO_DATE_COL + " TEXT,"
                + TODO_Description_COL + " TEXT)";
        db.execSQL(createTodoTableQuery);
    }

    public void AddToDo(ToDO todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TODO_TITLE_COL,(todo.getTitle()));
        values.put(TODO_DATE_COL,(todo.getDates()));
        values.put(TODO_Description_COL,(todo.getDes()));
        db.insert(TABLE_TODO,null,values);
        db.close();
    }
    public List<ToDO> getAllTodo(){
        List<ToDO>todo = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_TODO;

        Cursor cursor;
        cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                ToDO todos = new ToDO();
                todos.setId(cursor.getInt(0));
                todos.setTitle(cursor.getString(1));
                todos.setDates(cursor.getString(2));
                todos.setDes(cursor.getString(3));

                todo.add(todos);
            }while(cursor.moveToNext());
        }
        return todo;
    }
    public void DeleteToDo(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO,"Id = ?",new String[]{String.valueOf(id)});
        db.close();
    }
    public ToDO getSingleTodo(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_TODO,new String[]{ID_COL,TODO_TITLE_COL,TODO_DATE_COL,TODO_Description_COL},ID_COL+"=?",new String[]{String.valueOf(id)},null,null,null);

        ToDO todos;
        if(cursor != null) {
            cursor.moveToFirst();
            todos = new ToDO(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return todos;
        }
        return null;
    }
    public int UpdateTodos(ToDO todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TODO_TITLE_COL,todo.getTitle());
        values.put(TODO_DATE_COL,todo.getDates());
        values.put(TODO_Description_COL,todo.getDes());

        int status = db.update(TABLE_TODO,values,ID_COL+"=?",new String[]{String.valueOf(todo.getId())});
        db.close();
        return status;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
    }
}

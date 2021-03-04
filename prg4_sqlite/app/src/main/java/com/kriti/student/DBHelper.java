package com.kriti.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBName = "studentdb" ;
    private static final String TBN = "student";
    private static final int DBVERSION = 1;

    private String place_name = "name";
    private String place_usn ="usn";
    private String place_password ="password";
    private String place_admin = "admin";


    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Table in this function
        String createSQL = "CREATE TABLE "+TBN +"("+place_name+" VARCHAR(10), "+place_usn+" VARCHAR(10) PRIMARY KEY, "+place_password+" VARCHAR(10), "+place_admin+" INT);" ;
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBN);
        onCreate(db);
    }

    public Integer getData(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TBN+" where "+place_usn+"=\""+usn+"\"", null );
        int count = res.getCount();
        res.close();
        return count;
    }

    public Integer checkPw(String usn, String pw) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TBN+" where "+place_usn+"=\""+usn+"\" AND "+place_password+"=\""+pw+"\"", null );
        int count = res.getCount();
        res.close();
        return count;
    }

    public Integer checkAdmin(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select "+place_admin+" from "+TBN+" where "+place_usn+"=\""+usn+"\"", null );
        res.moveToFirst();
        int count = res.getInt(0);
        res.close();
        return count;
    }

    public void insertStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();  // open the database in the writable format
        ContentValues cv = new ContentValues() ; // To prepare the data for insert (Key, value) key - column name, value
        cv.put(place_name,student.getName());
        cv.put(place_usn, student.getUsn());
        cv.put(place_password, student.getPassword());
        cv.put(place_admin, student.getAdmin());
        db.insert(TBN,null, cv);
        db.close();
    }

    public boolean deleteUsn(String usn)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TBN, place_usn + "=?", new String[]{usn}) > 0;
    }

    // Update
    public void updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase() ; // Open the database in writable format
        String cmd = "UPDATE "+TBN+" SET "+place_password+" = '"+student.getPassword()+"' WHERE usn = '"+student.getUsn()+"';";
        db.execSQL(cmd);
    }



    Student getStudent(String usn){
        SQLiteDatabase db = this.getReadableDatabase() ;

        Cursor cursor = db.query(
                TBN, new String[]{place_name,place_usn,place_password,place_admin},place_usn+="=?",new String[]{usn},null,
                null,null);
        cursor.moveToFirst();

        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        return student;
    }

    public List<Student> getAllStudent(){

        List<Student> studentlist = new ArrayList<Student>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TBN, null);
        if(cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setName(cursor.getString(0));
                student.setUsn(cursor.getString(1));
                student.setPassword(cursor.getString(2));
                student.setAdmin(cursor.getInt(3));

                studentlist.add(student);
            }while (cursor.moveToNext());
        }
        return  studentlist;
    }

}

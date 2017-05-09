package kh.edu.rupp.fe.ruppmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;

/**
 * Created by Kakada_Surakkiat on 5/9/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final String _DB_NAME = "RUPPMAD.db";
    public static final String _TABLE_NAME = "assignment";
    public static final String _COLUMN_ID = "_id";
    public static final String _COLUMN_TITLE = "_title";
    public static final String _COLUMN_DEADLINE = "_deadline";
    public static final String _COLUMN_DESC = "_description";
    public static final String _COLUMN_IMAGE = "_image";

    public Database(Context context) {
        super(context, _DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        String sql = "delete table assignment";
        String sql = "CREATE TABLE assignment (_id INTEGER PRIMARY KEY AUTOINCREMENT, _title TEXT, _deadline TEXT, _image TEXT, _description TEXT)";
        db.execSQL(sql);
//        db.delete("assignment", null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("DROP TABLE IF EXISTS assignment");
        db.execSQL(sql);
    }

    public boolean insertAssignment(String title, String deadline, String image, String desc) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(_COLUMN_TITLE, title);
        contentValues.put(_COLUMN_DEADLINE, deadline);
        contentValues.put(_COLUMN_IMAGE, image);
        contentValues.put(_COLUMN_DESC, desc);
        long insertion = db.insert(_TABLE_NAME, null, contentValues);
        return (insertion != -1);
    }


    public List<Assignment> getAssignmentData(){
        List<Assignment> assignmentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String[] selectedCoulumns = {_COLUMN_ID,_COLUMN_TITLE,_COLUMN_DEADLINE,_COLUMN_IMAGE, _COLUMN_DESC};

        Cursor cursor = db.rawQuery("SELECT * FROM assignment",null);
        cursor.moveToFirst();

        while (cursor.moveToNext()){
            Assignment assignment = new Assignment();
            assignment.setId(cursor.getInt(0));
            assignment.setTitle(cursor.getString(1));
            assignment.setDeadline(cursor.getString(2));
            assignment.setImgThumbnail(cursor.getString(3));
            assignment.setDescription(cursor.getString(4));
            assignmentList.add(assignment);
        }
        cursor.close();
        return assignmentList;
    }

}

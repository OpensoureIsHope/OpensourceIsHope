package com.semi.sopt_19th_2.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.semi.sopt_19th_2.Database.ItemData;
import com.semi.sopt_19th_2.MainActivity;

import java.util.ArrayList;

import static java.sql.DriverManager.println;

/**
 * Created by hyejin on 2016-11-27.
 */

/**
 * DB에 대한 함수가 정의된 곳
 *
 */
public class DbOpenHelper {
    public static final String DATABASE_NAME = "ossteam.db";
    public static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private ArrayList<ItemData> itemDatas = null;



    public class DatabaseHelper extends SQLiteOpenHelper {

        // 생성자
        public DatabaseHelper(Context context, String name,  CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Databases.CreateDB._s);


        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ Databases.CreateDB._TABLENAME);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }


    // id name number check time image
    public void DbInsertJoin(String id, String pwd, String name, String major, String gender, String image){


        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("pwd", pwd);
        values.put("name",name);
        values.put("major",major);
        values.put("gender",gender);
        values.put("image", image);


        mDB.insert("memberinfo",null,values);

    }

    /**
     * DB항목 업그레이드 - 수정할 때 사용
     * @param id
     * @param pwd
     * @param major
     * @param name
     * @param gender
     * @param img

    public void DbUpdate(String id, String pwd, String name, String major ,String gender, String img){

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("number",number);
        values.put("time",time);
        values.put("image",img);

        mDB.update("devices", values, "_id=?", new String[]{id});

    }
*/


    /**
     * 항목 삭제하는 함수
     * @param id
     */
    public void DbDeleteJoin(String id) {

        mDB.delete("memberinfo", "_id=?", new String[]{id});

    }
//로그인을 위해 체크하는 함수
    public int DbSelectUser(String id){
        mDB = mDBHelper.getReadableDatabase();
        String SQL = "select * "+" from "+"join"+" where id=?";
        String[] args ={id};

        Cursor c1 =mDB.rawQuery(SQL, args);
        int recordCount = c1.getCount();
        if(recordCount==0)
            return 0;
        else
            return 1;

    }
    /**
     * devices테이블에 저장되어있는 값들을 반환하는 함수 - 리스트뷰 뿌릴 때 호출
     * @return
     */
    public void DbSelectJoin() {
        mDB = mDBHelper.getReadableDatabase();
        Cursor c = mDB.rawQuery("select * from memberinfo;", null);


//        Log.i("dbtest" , "갯수 : " + String.valueOf(c.getCount()));

        int recordCount = c.getCount();
        println("cursor count : " + recordCount + "\n");
        itemDatas = new ArrayList<ItemData>();
        ItemData listViewItem = new ItemData();
        for (int i = 0; i < recordCount; i++) {
            c.moveToNext();

            String _id = c.getString(0);
            String id = c.getString(1);
            String pwd = c.getString(2);
            String name = c.getString(3);
            String major = c.getString(4);
            String gender = c.getString(5);
            println(name + id + pwd + major + gender + _id);

            listViewItem.id=id;
            listViewItem.name = name;
            listViewItem.pwd = pwd;
            listViewItem.major = major;
            listViewItem.gender = gender;

            listViewItem.name = name;
            itemDatas.add(listViewItem);
        }
        c.close();

}
    public void close(){
        mDB.close();
    }

}


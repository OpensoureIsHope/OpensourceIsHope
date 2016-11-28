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

        private SQLiteDatabase mDB;

        // 생성자
        public DatabaseHelper(Context context, String name,  CursorFactory factory, int version) {

            super(context, name, factory, version);
            getReadableDatabase();
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Databases.CreateDB._s);
            open();
            this.mDB = mDB;

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
        mDBHelper.getWritableDatabase();
        return this;
    }


    // id name number check time image
    public void DbInsertJoin(ItemData itemDatas){
        String query = "select * from memberinfo";


        mDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        System.out.println("체크용용용1");
        open();

        Cursor c1 = mDB.rawQuery(query, null);
       // int count = c1.getCount();
        //values.put("ID", count);
        values.put("id", itemDatas.getId());
        values.put("pwd", itemDatas.getPwd());
        values.put("name", itemDatas.getName());
        values.put("major", itemDatas.getMajor());
        values.put("gender", itemDatas.getGender());
        values.put("image", itemDatas.getImg());

        System.out.println("체크용용용2");

        mDB.insert("memberinfo", null, values);
        System.out.println("체크용용용3");
        mDB.close();

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
    public String DbSelectUser(String id){
        System.out.println("체크용용용4");
        open();

        String SQL = "select id, pwd from memberinfo";
        String a, b;
        b = "찾지못하였습니다.";
           mDB = mDBHelper.getReadableDatabase();
            Cursor c1 = mDB.rawQuery(SQL, null);
        System.out.println("체크용용용5");

        if (c1.moveToFirst()) {
                do {
                    a = c1.getString(0);
                    b = c1.getString(1);

                    if (a.equals(id)) {
                        b = c1.getString(1);
                        break;
                    }
                }
                while (c1.moveToNext());
            }
        System.out.println("체크용용용6");

        return b;
    }
    /**
     * devices테이블에 저장되어있는 값들을 반환하는 함수 - 리스트뷰 뿌릴 때 호출
     * @return
     */
    public void DbSelectJoin() {
        mDB = mDBHelper.getReadableDatabase();
        Cursor c = mDB.rawQuery("select * from memberinfo", null);
        open();

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


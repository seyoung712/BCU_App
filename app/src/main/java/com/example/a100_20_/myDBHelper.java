package com.example.a100_20_;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//SQLiteOpenHelper라는 DB생성. 테이블을 생성하는 클래스 사용,  myDBHelper : 내부클래스 사용
public class myDBHelper extends SQLiteOpenHelper {
    //(1) DB 생성,  DB명 : reviewDB
    public myDBHelper(Context context) {
        super(context, "reviewDB", null, 1);
    }

    //(2) 테이블 생성,  Table명 : movie1TBL & 열 이름 : Num, content
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL 쿼리문 작성 시 사용하는 클래스
        db.execSQL("CREATE TABLE movie1TBL(Num INTEGER PRIMARY KEY, Content CHAR(100), Date CHAR(50), Score DOUBLE)");
        db.execSQL("CREATE TABLE movie2TBL(Num INTEGER PRIMARY KEY, Content CHAR(100), Date CHAR(50), Score DOUBLE)");
    }

    //(3) 테이블 삭제하고 다시 생성
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS movie1TBL");//삭제
        db.execSQL("DROP TABLE IF EXISTS movie2TBL");//삭제
        onCreate(db);//생성
    }//onUpgrade
}//myDBHelper Class

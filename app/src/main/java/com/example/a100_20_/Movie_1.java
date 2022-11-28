package com.example.a100_20_;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie_1 extends AppCompatActivity {
    myDBHelper myHelper;
    SQLiteDatabase sqlDB; //INSERT,SELECT 명령수행. execSQL()를 수행하기 위한 클래스 인스턴스

    SQLiteDatabase db = null; //DB생성
    EditText edt; //리뷰 입력창
    Button btn1; //'등록'버튼
    Button btn2; //'새로고침'버튼(조회 기능)
    TextView t1, t2, t3; //리뷰 출력창
    int Num=0;//카운트 변수 (기본키)
    Double star=0.0; //별점의 점수를 변수에 저장

    //1. 화면이 열리자마자 onCreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_1);

        //상위 액티비티로 이동 ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        edt=(EditText)findViewById(R.id.edt_insert); //리뷰 입력창
        btn1=(Button)findViewById(R.id.btn_insert); //등록버튼
        btn2=(Button)findViewById(R.id.btn_select); //새로고침(조회)
        t1=(TextView) findViewById(R.id.text1); //리뷰 출력창(내용)
        t2=(TextView) findViewById(R.id.text2); //리뷰 출력창(날짜)
        t3=(TextView) findViewById(R.id.text3); //리뷰 출력창(별점)
        myHelper = new myDBHelper(this); //myHelper 생성자 생성, myDBHelper가 현재의 클래스를 가지고

        starSize(); //별점을 클릭하면 값이 변수에 저장됨
    }//onCreate Class

    //현재 시간을 표시하는 함수
    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String getTime = dateFormat.format(date);

        return getTime;
    }//getTime

    //별점을 클릭하면 값이 변수에 저장됨
    public double starSize() {
        final RatingBar rb = (RatingBar)findViewById(R.id.rating); //별점 전역변수로 선언
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                star = (double)rb.getRating();
            }
        });
        return star;
    }//starSize

    //3. 입력버튼을 누르면 DB에 리뷰가 저장되게 하는 메소드 "INSERT"
    public void onButtonClicked1(View view){
        sqlDB = myHelper.getWritableDatabase(); //쓰기전용으로 DB열기
        Num=Num+1;
        double star = starSize();
        sqlDB.execSQL("INSERT INTO movie1TBL VALUES(" + Num + ",'" + edt.getText().toString()
                + "','" + getTime().toString() + "'," + star + ");"); //star = double
        //num은 기본키 (카운트 역할) + edt는 등록한 리뷰 string으로 가져오기 + date 현재날짜 + score 별점

        Toast.makeText(getApplicationContext(), "리뷰가 입력되었습니다.", Toast.LENGTH_SHORT).show();
        sqlDB.close();

    }//onButtonClicked1 (Insert)


    //4. 새로고침 버튼을 누르면 입력한 리뷰가 조회되는 메소드 "SELECT"
    public void onButtonClicked2(View view){
        sqlDB = myHelper.getWritableDatabase(); //읽기전용으로 DB열기
        //읽어온 레코드는 2차원 배열의 형식임, 2차원 배열을 Cursor클래스에 인스턴스로 저장
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM movie1TBL;", null);
        //select문은 rawQuery()

        String text=""; //리뷰 저장 변수
        String Date=""; //날짜 저장 변수
        String Score=""; //별점 저장 변수

        //레코드 추출
        while (cursor.moveToNext()) { //다음 행이 있으면 추출, 다음 행(리뷰)이 없으면 종료
            text += cursor.getString(1) + "\r\n\n"; //1열(리뷰내용)의 값을 가져옴, 개행처리 (0부터 시작, 0은 카운트데이터라 포함X)
            Date += cursor.getString(2) + "\r\n\n"; //2열(현재시간)의 값을 가져옴
            Score += cursor.getDouble(3) + "\r\n\n"; //3열(별점)의 값을 가져옴 * Double+String => String
        }//while

        //레코드 수집 후 화면에 표시
        t1.setText(text); //Date 변수에 누적된 리뷰 내용을 text1(t1) 영역에 출력하는 명령(setText)
        t2.setText(Date); //text 변수에 누적된 리뷰 내용을 text2(t2) 영역에 출력하는 명령(setText)
        t3.setText(Score);
        sqlDB.close();
    }//onButtonClicked2 (Select)

    //5. 초기화
    public void onButtonClicked3(View view){
        sqlDB=myHelper.getWritableDatabase(); //쓰기전용 열기
        myHelper.onUpgrade(sqlDB,1,2); //새 버전으로 변경 (1->2)
        sqlDB.close();
    }//onButtonClicked3
}//Movie_1

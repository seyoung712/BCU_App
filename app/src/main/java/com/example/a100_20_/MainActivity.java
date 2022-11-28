package com.example.a100_20_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startLoading(); //로딩 화면 함수
    }//onCreate

    //로딩 화면 함수
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent); //화면 띄우기
                finish(); //현재 액티비티 종료
            }
        }, 2000);
    }//startLoading

}//class-MainActivity

package com.example.a100_20_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Depart extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depart);

        //상위 액티비티로 이동 ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }//onCreate

    public void onTextClicked(View view){
        Intent i1;
        switch (view.getId()){
            case R.id.text1: //신세계문화홀 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text2: //신세계 카드센터 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text3: //아라리오갤러리 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
        }
    }//onTextClicked1
}//Depart class

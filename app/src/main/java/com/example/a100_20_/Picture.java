package com.example.a100_20_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Picture extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        //상위 액티비티로 이동 ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    //텍스트 클릭 시
    public void onTextClicked(View view){
        Intent i1;
        switch (view.getId()){
            case R.id.text11: //인생네컷1 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1253840596?c=14152657.3851641,4415743.3548892,13,0,0,0,dh&placePath=%2Fhome%3Fentry=plt"));
                startActivity(i1);
            case R.id.text12: //인생네컷1 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text21: //인생네컷2 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1027727172?c=14154935.7945781,4413745.2996373,13,0,0,0,dh&placePath=%2Fhome%3Fentry=plt"));
                startActivity(i1);
            case R.id.text22: //인생네컷2 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text31: //셀픽스1 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1506424391?c=14152626.160046976,4415503.471094349,13,0,0,0,dh&placePath=%2Fhome%3Fentry=plt"));
                startActivity(i1);
            case R.id.text32: //셀픽스1 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text41: //셀픽스2 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/1304391575?c=14154790.222079951,4413766.95046844,13,0,0,0,dh&placePath=%2Fhome%3Fentry=plt"));
                startActivity(i1);
            case R.id.text42: //셀픽스3 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
        }
    }//onTextClicked1
}

package com.example.a100_20_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        //상위 액티비티로 이동 ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }//onCreate

    //텍스트 클릭 시
    public void onTextClicked(View view){
        Intent i1;
        switch (view.getId()){
            case R.id.text11: //양궁 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.map.naver.com/search2/search.naver?query=%EC%B2%9C%EC%95%88%20%EB%8F%99%EB%82%A8%EA%B5%AC%20%EC%B2%AD%EC%88%98%2014%EB%A1%9C%2056%208%EC%B8%B5&sm=hty&style=v5"));
                startActivity(i1);
            case R.id.text12: //양궁 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text21: //총 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B6%A9%EC%B2%AD%EB%82%A8%EB%8F%84%20%EC%B2%9C%EC%95%88%EC%8B%9C%20%EC%84%9C%EB%B6%81%EA%B5%AC%20%EB%B6%80%EC%84%B11%EA%B8%B8%203/address/14152674.23893505,4415999.69773067,%EC%B6%A9%EC%B2%AD%EB%82%A8%EB%8F%84%20%EC%B2%9C%EC%95%88%EC%8B%9C%20%EC%84%9C%EB%B6%81%EA%B5%AC%20%EB%B6%80%EC%84%B11%EA%B8%B8%203,new?c=14152639.9191360,4416001.7144505,19,0,0,0,dh"));
                startActivity(i1);
            case R.id.text22: //총 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
            case R.id.text31: //볼링 지도보기
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/search/%EC%B6%A9%EB%82%A8%20%EC%B2%9C%EC%95%88%EC%8B%9C%20%EB%8F%99%EB%82%A8%EA%B5%AC%20%EB%A7%8C%EB%82%A8%EB%A1%9C%2058/address/14155248.902909812,4413867.640622105,%EC%B6%A9%EC%B2%AD%EB%82%A8%EB%8F%84%20%EC%B2%9C%EC%95%88%EC%8B%9C%20%EB%8F%99%EB%82%A8%EA%B5%AC%20%EB%A7%8C%EB%82%A8%EB%A1%9C%2058,new?c=14155224.2901704,4413869.6708435,19,0,0,0,dh"));
                startActivity(i1);
            case R.id.text32: //볼링 평가보기 페이지 이동
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947?c=14153622.4026979,4412346.8632633,15,0,0,0,dh"));
                startActivity(i1);
        }
    }//onTextClicked1
}//Activity class

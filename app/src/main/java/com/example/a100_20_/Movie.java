package com.example.a100_20_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Movie extends AppCompatActivity {
//    int avg1=0, avg2=0;
//    int count=0;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        RatingBar r1 = (RatingBar)findViewById(R.id.star1);
        RatingBar r2 = (RatingBar)findViewById(R.id.star2);
        //상위 액티비티로 이동 ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

/*
        //레이팅바가 변경되면 평균 별점을 출력
        r1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int sum1 = (int)r1.getRating();
                count += 1;
                avg1=sum1/count;
                //r1.setRating(avg1);
                Toast.makeText(getApplicationContext(),avg1,Toast.LENGTH_LONG).show();
            }
        });
*/

    }//onCreate

    //텍스트 클릭 시
    public void onTextClicked(View view){
        switch (view.getId()){
            case R.id.text1: //cgv 지도보기
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/12257947"));
            case R.id.text2: //메가박스 지도보기
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/v5/entry/place/38420336?c=14153532.2227784,4415783.8831006,15,0,0,0,dh"));
        }
    }//onTextClicked

    public void onBtnClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1: //cgv 리뷰 페이지 이동
                intent = new Intent(getApplicationContext(), Movie_1.class);
                startActivity(intent);
                break;
            case R.id.btn2: //메가박스 리뷰 페이지 이동
                intent = new Intent(getApplicationContext(), Movie_2.class);
                startActivity(intent);
                break;
        }
    }//onbtnClicked

}//Movie Class

package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C6Activity extends Activity {
    Button btnC6,btnC6A,btnC6B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6);
        btnC6=(Button)findViewById(R.id.btnC6);
        btnC6A=(Button)findViewById(R.id.btnC6A);
        btnC6B=(Button)findViewById(R.id.btnC6B);
        btnC6B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC6:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/38654098/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC6A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/38654098/home?entry=plt"));
        }
        startActivity(i1);
    }
}

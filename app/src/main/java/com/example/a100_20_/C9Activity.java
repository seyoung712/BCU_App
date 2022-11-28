package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C9Activity extends Activity {
    Button btnC9,btnC9A,btnC9B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c9);
        btnC9=(Button)findViewById(R.id.btnC9);
        btnC9A=(Button)findViewById(R.id.btnC9A);
        btnC9B=(Button)findViewById(R.id.btnC9B);
        btnC9B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC9:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/31668276/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC9A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/31668276/home?entry=plt"));
        }
        startActivity(i1);
    }
}

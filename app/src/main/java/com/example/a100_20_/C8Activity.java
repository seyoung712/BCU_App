package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C8Activity extends Activity {
    Button btnC8,btnC8A,btnC8B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c8);

        btnC8=(Button)findViewById(R.id.btnC8);
        btnC8A=(Button)findViewById(R.id.btnC8A);
        btnC8B=(Button)findViewById(R.id.btnC8B);
        btnC8B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC8:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1314229113/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC8A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/1314229113/home?entry=plt"));
        }
        startActivity(i1);
    }
}

package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C7Activity extends Activity {
    Button btnC7,btnC7A,btnC7B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c7);
        btnC7=(Button)findViewById(R.id.btnC7);
        btnC7A=(Button)findViewById(R.id.btnC7A);
        btnC7B=(Button)findViewById(R.id.btnC7B);
        btnC7B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v) {
        Intent i1 = null;
        switch (v.getId()) {
            case R.id.btnC1:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/38343914/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC1A:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/38343914/home?entry=plt"));
        }
        startActivity(i1);
    }
}

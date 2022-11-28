package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C4Activity extends Activity {
    Button btnC4,btnC4A,btnC4B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c4);

        btnC4=(Button)findViewById(R.id.btnC4);
        btnC4A=(Button)findViewById(R.id.btnC4A);
        btnC4B=(Button)findViewById(R.id.btnC4B);
        btnC4B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC4:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1537898657/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC4A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/1537898657/home?entry=plt"));
        }
        startActivity(i1);
    }
}

package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C11Activity extends Activity {
    Button btnC11,btnC11A,btnC11B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c11);

        btnC11=(Button)findViewById(R.id.btnC11);
        btnC11A=(Button)findViewById(R.id.btnC11A);
        btnC11B=(Button)findViewById(R.id.btnC11B);
        btnC11B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC11:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1552090351/location?entry=pll&subtab=location"));
                break;
            case R.id.btnC11A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/1552090351/home?entry=pll"));
        }
        startActivity(i1);
    }
}

package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C3Activity extends Activity {
    Button btnC3,btnC3A,btnC3B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c3);

        btnC3=(Button)findViewById(R.id.btnC3);
        btnC3A=(Button)findViewById(R.id.btnC3A);
        btnC3B=(Button)findViewById(R.id.btnC3B);
        btnC3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC3:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/38238630/location?entry=pll&subtab=location"));
                break;
            case R.id.btnC3A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/38238630/home?entry=pll"));
        }
        startActivity(i1);
    }
}

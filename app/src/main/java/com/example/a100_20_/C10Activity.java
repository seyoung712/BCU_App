package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C10Activity extends Activity {
    Button btnC10,btnC10A,btnC10B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10);

        btnC10=(Button)findViewById(R.id.btnC10);
        btnC10A=(Button)findViewById(R.id.btnC10A);
        btnC10B=(Button)findViewById(R.id.btnC10B);
        btnC10B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC10:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/19981767/location?entry=pll&subtab=location"));
                break;
            case R.id.btnC10A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/19981767/home?entry=pll"));
        }
        startActivity(i1);
    }
}

package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C1Activity extends Activity {
    Button btnC1,btnC1A,btnC1B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1);

        btnC1=(Button)findViewById(R.id.btnC1);
        btnC1A=(Button)findViewById(R.id.btnC1A);
        btnC1B=(Button)findViewById(R.id.btnC1B);
        btnC1B.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC1:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/1574418777/location?entry=plt&subtab=location"));
                break;
            case R.id.btnC1A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/1574418777/home?entry=plt"));
        }
        startActivity(i1);
    }

}

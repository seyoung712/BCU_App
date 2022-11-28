package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C2Activity extends Activity {
    Button btnC2,btnC2A,btnC2B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2);

        btnC2=(Button)findViewById(R.id.btnC2);
        btnC2A=(Button)findViewById(R.id.btnC2A);
        btnC2B=(Button)findViewById(R.id.btnC2B);
        btnC2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC2:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/36069401/location?subtab=location"));
                break;
            case R.id.btnC2A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/36069401/home"));
        }
        startActivity(i1);
    }
}

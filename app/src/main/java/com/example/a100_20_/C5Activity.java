package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class C5Activity extends Activity {
    Button btnC5,btnC5A,btnC5B;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c5);

        btnC5=(Button)findViewById(R.id.btnC5);
        btnC5A=(Button)findViewById(R.id.btnC5A);
        btnC5B=(Button)findViewById(R.id.btnC5B);
        btnC5B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void onClick(View v){
        Intent i1 = null;
        switch (v.getId()){
            case R.id.btnC5:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/34304784/location?subtab=location"));
                break;
            case R.id.btnC5A:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.place.naver.com/restaurant/34304784/home"));
        }
        startActivity(i1);
    }
}

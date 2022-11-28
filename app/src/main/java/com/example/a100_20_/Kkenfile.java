package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Kkenfile extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kkenfile);
    }
    public void onTextClicked(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.text94:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/12809719/location?entry=pll&subtab=location"));
                startActivity(i1);
        }
    }
}
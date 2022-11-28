package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Bbunfile extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbunfile);
    }
    public void onTextClicked(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.text92:
                i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1802309873/location?entry=plt&subtab=location"));
                startActivity(i1);
        }
    }
}


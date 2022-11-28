package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Kenfile extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kenfile);
    }
    public void onClick(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.hoola2:
                i1 = new Intent(this, Kkenfile.class);
                startActivity(i1);
                break;
            case R.id.bul2:
                i1 = new Intent(this, Kkkenfile.class);
                startActivity(i1);
                break;
        }
    }
}


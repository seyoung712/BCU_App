package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Bunfile extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bunfile);
    }
    public void onClick(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.chung2:
                i1 = new Intent(this, Bbunfile.class);
                startActivity(i1);
                break;
            case R.id.guk2:
                i1 = new Intent(this, Bbbunfile.class);
                startActivity(i1);
                break;
        }
    }
}


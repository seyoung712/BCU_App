package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Choice1_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice1);
    }

    public void onImageClicked(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.image1:
                i1 = new Intent(this, Xmlfile.class);
                startActivity(i1);
                break;
            case R.id.image2:
                i1 = new Intent(this, Bunfile.class);
                startActivity(i1);
                break;
            case R.id.image3:
                i1 = new Intent(this, Kenfile.class);
                startActivity(i1);
                break;
        }
    }
}
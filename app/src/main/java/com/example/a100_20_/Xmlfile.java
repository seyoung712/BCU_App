package com.example.a100_20_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Xmlfile extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlfile);
    }

    public void onClick(View view) {
        Intent i1;
        switch (view.getId()) {
            case R.id.jaraku2:
                i1 = new Intent(this, Xxmlfile.class);
                startActivity(i1);
                break;
            case R.id.dong2:
                i1 = new Intent(this, Xxxmlfile.class);
                startActivity(i1);
                break;
        }
    }
}
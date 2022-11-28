package com.example.a100_20_;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Choice3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice3);

        //상위 액티비티로 이동(메인화면) ->Manifest.xml
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void onImageClicked(View view){
        Intent i1;
        switch (view.getId()){
            case R.id.image1: //영화관 이동
                i1 = new Intent(this, Movie.class);
                startActivity(i1);
                break;
            case R.id.image2: //액티비티 이동
                i1 = new Intent(this, Activity.class);
                startActivity(i1);
                break;
            case R.id.image3: //백화점 이동
                i1 = new Intent(this, Depart.class);
                startActivity(i1);
                break;
            case R.id.image4: //사진 이동
                i1 = new Intent(this, Picture.class);
                startActivity(i1);
                break;
        }
    }

}//choice3_Activity
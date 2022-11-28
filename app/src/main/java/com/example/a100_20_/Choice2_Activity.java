package com.example.a100_20_;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Choice2_Activity extends AppCompatActivity {
    Button btnBu,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
    ImageButton imgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice2);
    btnBu = (Button) findViewById(R.id.btnBu);
    imgBtn = (ImageButton) findViewById(R.id.imgBtn);
    c1 = (Button)findViewById(R.id.c1);
    c2 = (Button)findViewById(R.id.c2);
    c3 = (Button)findViewById(R.id.c3);
    c4 = (Button)findViewById(R.id.c4);
    c5 = (Button)findViewById(R.id.c5);
    c6 = (Button)findViewById(R.id.c6);
    c7 = (Button)findViewById(R.id.c7);
    c8 = (Button)findViewById(R.id.c8);
    c9 = (Button)findViewById(R.id.c9);
    c10 = (Button)findViewById(R.id.c10);
    c11 = (Button)findViewById(R.id.c11);
    c1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),C1Activity.class);
            startActivity(intent);
        }
    });
    c2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C2Activity.class);
            startActivity(intent);
        }
    });
    c3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C3Activity.class);
            startActivity(intent);
        }
    });
    c4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C4Activity.class);
            startActivity(intent);
        }
    });
    c5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C5Activity.class);
            startActivity(intent);
        }
    });
    c6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C6Activity.class);
            startActivity(intent);
        }
    });
    c7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),C7Activity.class);
            startActivity(intent);
        }
    });
    c8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C8Activity.class);
            startActivity(intent);
        }
    });
    c9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), C9Activity.class);
            startActivity(intent);
        }
    });
    c10.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),C10Activity.class);
            startActivity(intent);
        }
    });
    c11.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),C11Activity.class);
            startActivity(intent);
        }
    });
    }//onCreate
    public void onClick(View v){
        Intent i1;
        switch (v.getId()){
            case R.id.btnBu:
                i1 = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:36.840229,127.18317"));
                startActivity(i1);
                break;
            case R.id.imgBtn:
                i1 = new Intent(this,Main.class);
                startActivity(i1);
                break;
        }
    }

}//MainActivity
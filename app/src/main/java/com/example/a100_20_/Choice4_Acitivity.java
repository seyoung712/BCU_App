package com.example.a100_20_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Choice4_Acitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice4);

        ImageButton imageButton = findViewById(R.id.friend);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FriendWrite.class);
            startActivity(intent);
        });

        ImageButton imageButton1 = findViewById(R.id.club);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClubWrite.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton2 = findViewById(R.id.festival);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FestivalWrite.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton3 = findViewById(R.id.restaurant);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RestaurantWrite.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton4 = findViewById(R.id.InformationSharing);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InformationsharingWrite.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton5 = findViewById(R.id.etc);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EtcWrite.class);
                startActivity(intent);
            }
        });
    }
}

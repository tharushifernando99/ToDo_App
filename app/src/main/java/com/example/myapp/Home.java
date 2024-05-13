package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button2 = findViewById(R.id.button2);
        button2.setBackgroundColor(Color.parseColor("#f49b27"));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, DashBoard.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
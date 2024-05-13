package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class DashBoard extends AppCompatActivity {
    private Button button1;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, AddNew.class);
                startActivity(intent);
                finish();
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, ViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
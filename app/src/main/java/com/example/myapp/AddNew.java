package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class AddNew extends AppCompatActivity {
    Button button;
    EditText EdiTitle,EdiDate,EdiDes;
    DBhelper DB;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        button = findViewById(R.id.button);
        EdiTitle = findViewById(R.id.editTextText);
        EdiDate = findViewById(R.id.editTextText2);
        EdiDes = findViewById(R.id.editTextText3);

        context = this;
        DB = new DBhelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = EdiTitle.getText().toString();
                String DateDo = EdiDate.getText().toString();
                String Description = EdiDes.getText().toString();
                ToDO todo = new ToDO(Title,DateDo,Description);
                DB.AddToDo(todo);
                Intent intent = new Intent(AddNew.this,ViewActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}




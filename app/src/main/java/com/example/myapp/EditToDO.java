package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditToDO extends AppCompatActivity {
    Button button;
    EditText EditTitle,EditDates,EditDes;
    DBhelper DB;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);

        button = findViewById(R.id.button);

        EditTitle = findViewById(R.id.editTextText);
        EditDates = findViewById(R.id.editTextText2);
        EditDes = findViewById(R.id.editTextText3);
        context = this;
        DB = new DBhelper(this);

        final String id = getIntent().getStringExtra("id");
        ToDO todo = DB.getSingleTodo(Integer.parseInt(id));

        EditTitle.setText(todo.getTitle());
        EditDates.setText(todo.getDates());
        EditDes.setText(todo.getDes());
        System.out.println(id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TitleText = EditTitle.getText().toString();
                String DateText = EditDates.getText().toString();
                String DesText = EditDes.getText().toString();

                ToDO todo = new ToDO(Integer.parseInt(id),TitleText,DateText,DesText);
                int state =DB.UpdateTodos(todo);
                System.out.println(state);

                Intent intent = new Intent(EditToDO.this,ViewActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
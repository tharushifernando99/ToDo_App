package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    List<ToDO> todo;
    Context context;
    DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);

        button = findViewById(R.id.button3);
        listView = findViewById(R.id.todos);
        todo = new ArrayList<>();
        context = this;
        DB = new DBhelper(context);

        todo = DB.getAllTodo();
        ToDoAdapter Adapter = new ToDoAdapter(this, R.layout.items, todo);
        listView.setAdapter(Adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, AddNew.class);
                startActivity(intent);
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final ToDO todos = todo.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
                builder.setTitle(todos.getTitle());
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DB.UpdateTodos(todos);
                        Intent intent = new Intent(ViewActivity.this, AddNew.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ViewActivity.this, EditToDO.class);
                        intent.putExtra("id", String.valueOf(todos.getId()));
                        startActivity(intent);
                        finish();

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DB.DeleteToDo(todos.getId());
                        Intent intent = new Intent(ViewActivity.this, ViewActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                builder.show();
            }
        });

    }
}


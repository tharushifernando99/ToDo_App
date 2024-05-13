package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter {
    private Context context;
    private int resources;
    List<ToDO>todo;

    ToDoAdapter(Context context, int resources, List<ToDO>todo){
        super(context,resources,todo);
        this.context = context;
        this.resources = resources;
        this.todo=todo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resources, parent, false);

        TextView title = row.findViewById(R.id.Title);
        TextView days = row.findViewById(R.id.Days);
        TextView description= row.findViewById(R.id.Description);

        ToDO todos = todo.get(position);
        title.setText(todos.getTitle());
        days.setText(todos.getDates());
        description.setText(todos.getDes());
        return row;
    }
}

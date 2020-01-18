package com.example.todo;

//Added classes.
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.TodoAdapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mTodoListRV;
    private EditText mTodoEntryET;
    private TodoAdapter mTodoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoListRV = findViewById(R.id.rv_todo_list);
        mTodoEntryET = findViewById(R.id.et_todo_entry_box);

        mTodoAdapter = new TodoAdapter();

        mTodoListRV.setLayoutManager(new LinearLayoutManager(this));
        mTodoListRV.setHasFixedSize(true);

        mTodoListRV.setAdapter(mTodoAdapter);

        Button addTodoButton = findViewById(R.id.btn_ad_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoText = mTodoEntryET.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoAdapter.addTodo(todoText);
                    mTodoEntryET.setText("");
                }
            }
        });
    }
}
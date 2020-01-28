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
import androidx.recyclerview.widget.DefaultItemAnimator;

import android.os.Bundle;
import android.widget.Toast;

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
        mTodoListRV.setItemAnimator(new DefaultItemAnimator());
        mTodoListRV.setAdapter(mTodoAdapter);

        mTodoAdapter.addTodo("Fight the guy who lives down by the river at 6.");

        Button addTodoButton = findViewById(R.id.btn_ad_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoText = mTodoEntryET.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoListRV.scrollToPosition(0);
                    mTodoAdapter.addTodo(todoText);
                    Toast.makeText(MainActivity.this, "wow", Toast.LENGTH_SHORT).show();
                    mTodoEntryET.setText("");
                }
            }
        });
    }
}
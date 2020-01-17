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

    private RecyclerView mTodoListRecyclerView;
    private EditText mTodoEntryEditText;
    private TodoAdapter mTodoAdapter;
    private ArrayDeque<String> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTodoListRecyclerView.setHasFixedSize(true);

        mTodoEntryEditText = (EditText)findViewById(R.id.et_todo_entry_box);

        mTodoAdapter = new TodoAdapter();
        mTodoListRecyclerView.setAdapter(mTodoAdapter);

        Button addTodoButton = (Button)findViewById(R.id.btn_ad_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText =
                        mTodoEntryEditText.getText().toString();
                if (!TextUtils.isEmpty(todoText)) {
                    mTodoAdapter.addTodo(todoText);
                    mTodoEntryEditText.setText("");
                }
            }
        });
    }

}
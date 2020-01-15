package com.example.todo;

//Added classes.
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

import java.util.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the id of tv_todo_list text in the main.xml
        TextView todoListTextview = (TextView)findViewById(R.id.tv_todo_list);
        // Modify the text located at the tv_todo_list text.
        todoListTextview.setText("Finish my TODO app.");

        mTodoListTextView = (TextView)findViewById(R.id.tv_todo_list);
        mTodoEntryEditText = (EditText)findViewById(R.id.et_todo_entry_box);

        Button addTodoButton = (Button)findViewById(R.id.btn_ad_todo);
        addTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String todoText = mTodoEntryEditText.getText().toString();
                mTodoList = new ArrayDeque<String>();
                if (!TextUtils.isEmpty(todoText)){
                    mTodoList.push(todoText);
                    mTodoListTextView.setText("");
                    for (String todo : mTodoList) {
                        mTodoListTextView.append(todo + "\n\n");
                    }
                    mTodoEntryEditText.setText("");
                }
            }
        });
    }

    private TextView mTodoListTextView;
    private EditText mTodoEntryEditText;
    private ArrayDeque<String> mTodoList;
}

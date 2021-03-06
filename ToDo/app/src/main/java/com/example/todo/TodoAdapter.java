package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<String> mTodoList;

    public TodoAdapter() {
        mTodoList = new ArrayList<String>();
    }

    public void addTodo(String todo) {
        mTodoList.add(0, todo);
        notifyItemInserted(0);
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.todo_list_item, viewGroup, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int position) {
        //String todo = mTodoList.get(mTodoList.size() - i - 1);
        String todo = mTodoList.get(position);
        todoViewHolder.bind(todo);
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTodoTV;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoTV = itemView.findViewById(R.id.tv_todo_text);
        }

        public void bind(String todo) {
            mTodoTV.setText(todo);
        }
    }
}

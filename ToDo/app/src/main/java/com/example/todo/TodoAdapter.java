package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class TodoAdapter
        extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<String> mTodoList;


    public TodoAdapter(){
        mTodoList = new ArrayList<String>();
    }

    public void addTodo (String todo){
        mTodoList.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.todo_list_item, viewGroup,
                false);
        TodoViewHolder viewHolder = new TodoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        String todo = mTodoList.get(mTodoList.size() - position - 1);
        holder.bind(todo);
    }

    @Override
    public int getItemCount(){
        return mTodoList.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTodoTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoTextView = (TextView)itemView.findViewById(R.id.tv_todo_text);
        }

        void bind(String todo){
            mTodoTextView.setText(todo);
        }
    }
}

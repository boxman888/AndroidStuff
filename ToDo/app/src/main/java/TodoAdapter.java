import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

public class TodoAdapter
        extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<String> mTodoList;


    public TodoAdapter(){
        mTodoList = new ArrayList<String>();
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

    }

    public void addTodo (String todo){
        mTodoList.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return mTodoList.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTodoTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoTextView = (TextView)itemView.findViewById(R.id.rv_todo_text);
        }

        void bind(String todo){
            mTodoTextView.setText(todo);
        }
    }
}

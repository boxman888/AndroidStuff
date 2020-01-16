import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class TodoAdapter extends RecyclerView.Adapter {
    private ArrayList<String> mTodoList;

    public TodoAdapter(){
        mTodoList = new ArrayList<String>();
    }

    public void addTodo (String todo){
        mTodoList.add(todo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return mTodoList.size();
    }
}

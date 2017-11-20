package recyclerviewdemo.fujisoft.com.detailrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import recyclerviewdemo.fujisoft.com.detailrecyclerview.R;

/**
 * Created by 860617009 on 2017/11/9.
 */

public class AddRemoveAdapter extends RecyclerView.Adapter<AddRemoveAdapter.MyHolder> implements View.OnLongClickListener {

    protected Context context;
    protected List<String> list;

    public AddRemoveAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_simple, parent, false);
        MyHolder holder = new MyHolder(view);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean onLongClick(View view) {
        onLongClickListener.onLongClickListener(view, (int) view.getTag());
        return false;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_show_title);
        }
    }

    private OnLongClickListener onLongClickListener;

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public interface OnLongClickListener {
        void onLongClickListener(View view, int position);
    }
}

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

public class OnItemClickAdapter extends RecyclerView.Adapter<OnItemClickAdapter.OnItemClickHolder> implements View.OnClickListener {
    private Context context;
    private List<String> list;

    public OnItemClickAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OnItemClickHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_simple, parent, false);
        OnItemClickHolder holder = new OnItemClickHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(OnItemClickHolder holder, int position) {
        holder.textView.setText(list.get(position));
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.itemClickListener(view, (int) view.getTag());
    }

    class OnItemClickHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public OnItemClickHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_show_title);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void itemClickListener(View view, int position);
    }
}

package recyclerviewdemo.fujisoft.com.detailrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import recyclerviewdemo.fujisoft.com.detailrecyclerview.R;
import recyclerviewdemo.fujisoft.com.detailrecyclerview.adapter.OnItemClickAdapter;

public class ItemClickActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] strings = {"!123", "@456", "#789", "$741", "%852", "^963", "&159", "*753"};
    private List<String> list;//假数据
    private OnItemClickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click);
        list = new ArrayList<>();
        Collections.addAll(list, strings);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_item_click);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new OnItemClickAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickAdapter.OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                Toast.makeText(ItemClickActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

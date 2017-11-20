package recyclerviewdemo.fujisoft.com.detailrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import recyclerviewdemo.fujisoft.com.detailrecyclerview.R;
import recyclerviewdemo.fujisoft.com.detailrecyclerview.adapter.AddRemoveAdapter;
import recyclerviewdemo.fujisoft.com.detailrecyclerview.adapter.OnItemClickAdapter;

public class AddRemoveActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private String[] strings = {"qqq!123", "www@456", "eee#789", "rrr$741", "ggg%852", "fff^963", "ddd&159", "aaa*753"};
    private List<String> list;//假数据
    private AddRemoveAdapter adapter;
    private Button btnAddOne, btnRemoveOne, btnAddSome, btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove);
        init();
        logic();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_add_remove);
        list = new ArrayList<>();
        Collections.addAll(list, strings);
        btnAddOne = (Button) findViewById(R.id.btn_add_one);
        btnRemoveOne = (Button) findViewById(R.id.btn_remove_one);
        btnAddSome = (Button) findViewById(R.id.btn_add_some);
        btnChange = (Button) findViewById(R.id.btn_change);
        btnAddOne.setOnClickListener(this);
        btnRemoveOne.setOnClickListener(this);
        btnAddSome.setOnClickListener(this);
        btnChange.setOnClickListener(this);
    }

    private void logic() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new AddRemoveAdapter(this, list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setOnLongClickListener(new AddRemoveAdapter.OnLongClickListener() {
            @Override
            public void onLongClickListener(View view, int position) {
                Toast.makeText(AddRemoveActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_one:
                list.add(1,"头部添加一条数据");
                adapter.notifyItemInserted(1);
                recyclerView.scrollToPosition(1);
                break;
            case R.id.btn_add_some:
                list.add(1,"批量一");
                list.add(2,"批量二");
                list.add(3,"批量三");
                list.add(4,"批量四");
                adapter.notifyItemRangeInserted(1,4);
                recyclerView.scrollToPosition(1);
                break;
            case R.id.btn_remove_one:
                list.remove(3);
                adapter.notifyItemRemoved(3);
                break;
            case R.id.btn_change:
                adapter.notifyItemMoved(3,4);
                break;
        }
    }
}

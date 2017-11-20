package recyclerviewdemo.fujisoft.com.detailrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import recyclerviewdemo.fujisoft.com.detailrecyclerview.activity.AddRemoveActivity;
import recyclerviewdemo.fujisoft.com.detailrecyclerview.activity.ItemClickActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn1 = (Button) findViewById(R.id.btn_one);
        btn2 = (Button) findViewById(R.id.btn_two);
        btn3 = (Button) findViewById(R.id.btn_three);
        btn4 = (Button) findViewById(R.id.btn_four);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                startActivity(new Intent(this, ItemClickActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, AddRemoveActivity.class));
                break;
            case R.id.btn_three:
                break;
            case R.id.btn_four:
                break;
        }
    }
}

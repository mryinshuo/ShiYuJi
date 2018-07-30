package com.shiyuji;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Trneds extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<TrendsItem> itemList = new ArrayList<>();     // 定义一个ArrayList存放所有要添加的item
    private TextView titlea;
    private ListView trendsLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称
        titlea = (TextView) findViewById(R.id.titlea);
        titlea.setText(title);

        initItems();                                                                                            // 生成ListView内容
        TrendsItemAdapter adapter = new TrendsItemAdapter(this, R.layout.activity_trends_item, itemList);    // 声明adapter
        trendsLV = (ListView) findViewById(R.id.trendsLV);                                                      // 获得该ListView
        trendsLV.setAdapter(adapter);                                                                           // 设置adapter
        trendsLV.setOnItemClickListener(this);                                                                  // 监听item的click事件
        trendsLV.setDivider(null);                                                                              // 清除ListView分割线

        //论坛右下add按钮，进入写动态页面
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//alt+enter 打包
                Intent intent = new Intent(Trneds.this, Write.class);
                startActivity(intent);
            }
        });

        // 论坛左上取消按钮，返回主页
        ImageButton del1 = (ImageButton) findViewById(R.id.del1);
        del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initItems() {
        itemList.add(new TrendsItem("逗逗43组", "新人问一下，我国民族音乐中，四二，四三，四四拍又叫什么？(｡・`ω´･)", 0));
        itemList.add(new TrendsItem("丨锴", "求《小刀会序曲》总谱!很喜欢这个曲子啊！！！", R.drawable.p1));
        itemList.add(new TrendsItem("cool_gao", "古筝《如是》", R.drawable.g1));
        itemList.add(new TrendsItem("cool_gao", "古筝《如是》", R.drawable.g1));
        itemList.add(new TrendsItem("cool_gao", "古筝《如是》", R.drawable.g1));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(Trneds.this, self_write.class);
        startActivity(intent);
    }
}

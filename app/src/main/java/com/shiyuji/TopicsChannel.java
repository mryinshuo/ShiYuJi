package com.shiyuji;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.shiyuji.adapter.TopicsItemAdapter;
import com.shiyuji.model.TopicsItem;

import java.util.ArrayList;
import java.util.List;


public class TopicsChannel extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<TopicsItem> itemList = new ArrayList<>();     // 定义一个ArrayList存放所有要添加的item
    private TextView titlea;
    private ListView topicsLV;
    private SwipeRefreshLayout topicsSRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_topics);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称
        titlea = (TextView) findViewById(R.id.titlea);
        titlea.setText(title);

        initItems();                                                                                            // 生成ListView内容
        TopicsItemAdapter adapter = new TopicsItemAdapter(this, R.layout.channel_topics_item, itemList);    // 声明adapter
        topicsLV = (ListView) findViewById(R.id.topicsLV);                                                      // 获得该ListView
        topicsLV.setAdapter(adapter);                                                                           // 设置adapter
        topicsLV.setOnItemClickListener(this);                                                                  // 监听item的click事件
        topicsLV.setDivider(null);                                                                              // 清除ListView分割线

        //论坛右下add按钮，进入写动态页面
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsChannel.this, EditTopicChannel.class);
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

        topicsSRL = (SwipeRefreshLayout) findViewById(R.id.topicsSRL);
        topicsSRL.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        topicsSRL.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                topicsSRL.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        topicsSRL.setRefreshing(false);
                    }
                }, 800);
            }
        });
    }

    private void initItems() {
        itemList.add(new TopicsItem("逗逗43组", "新人问一下，我国民族音乐中，四二，四三，四四拍又叫什么？(｡・`ω´･)", 0, "10", "20", "30"));
        itemList.add(new TopicsItem("丨锴", "求《小刀会序曲》总谱!很喜欢这个曲子啊！！！", R.drawable.p1, "11", "21", "31"));
        itemList.add(new TopicsItem("cool_gao", "古筝《如是》", R.drawable.g1, "12", "22", "32"));
        itemList.add(new TopicsItem("cool_gao", "古筝《如是》", R.drawable.g1, "12", "22", "32"));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(TopicsChannel.this, TopicDetailActivity.class);
        startActivity(intent);
    }
}

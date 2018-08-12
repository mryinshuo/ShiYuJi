package com.shiyuji;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shiyuji.adapter.VideosChannelPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideosChannel extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> pagerList;
    private List<String> titleList;
    private ViewPager channelVideosVP;
    private TextView titlebarTV;
    private Button inheritor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_videos);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称
        titlebarTV = (TextView) findViewById(R.id.titlebarSText);
        titlebarTV.setText(title);

        init();
        channelVideosVP = (ViewPager) findViewById(R.id.channelVideosVP);
        VideosChannelPagerAdapter adapter = new VideosChannelPagerAdapter(this, pagerList, titleList);
        channelVideosVP.setAdapter(adapter);

        inheritor = (Button) findViewById(R.id.ChannelVideosInheritor);
        inheritor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ChannelVideosInheritor:
                Intent intent = new Intent(this, InheritorVideosChannel.class);
                startActivity(intent);
                break;
        }
    }

    public void init() {
        pagerList = new ArrayList<>();
        pagerList.add(R.layout.channel_videos_official);
        pagerList.add(R.layout.channel_videos_unofficial);

        titleList = new ArrayList<>();
        titleList.add("官方");
        titleList.add("非官方");
    }
}

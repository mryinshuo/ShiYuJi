package com.shiyuji;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
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

    private ImageView cursor;       //滚动条的动画。
    private int cursorWidth;        //动画的宽度。
    private int Offset;             //动画图片的偏移量。
    private int currIndex = 0;      //当前页码编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_videos);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称
        titlebarTV = (TextView) findViewById(R.id.titlebarSText);
        titlebarTV.setText(title);

        init();
        initCursorPos();
        channelVideosVP = (ViewPager) findViewById(R.id.channelVideosVP);
        VideosChannelPagerAdapter adapter = new VideosChannelPagerAdapter(this, pagerList, titleList);
        channelVideosVP.setAdapter(adapter);
        channelVideosVP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int one = Offset * 2 + cursorWidth;// 页卡1 -> 页卡2 偏移量

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            /*
            通过事件的监听，实现动画的切换
             */
            @Override
            public void onPageSelected(int position) {
                Animation animation = null;
                switch (position) {
                    case 0:
                        animation = new TranslateAnimation(one, 0, 0, 0);
                        break;
                    case 1:
                        animation = new TranslateAnimation(0, one, 0, 0);
                        break;
                }
                currIndex = position;
                animation.setFillAfter(true);// True:图片停在动画结束位置
                animation.setDuration(250);
                cursor.startAnimation(animation);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

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

    private void initCursorPos() {
        List<View> mViews = new ArrayList<>();
        mViews.add(View.inflate(this, pagerList.get(0), null));
        mViews.add(View.inflate(this, pagerList.get(1), null));
        // 初始化动画
        cursor = (ImageView) findViewById(R.id.videosVPTitleCursor);
        cursorWidth = BitmapFactory.decodeResource(getResources(), R.drawable.pagerview_title_cursor).getWidth();// 获取图片宽度
        //获得屏幕的宽度
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenW = metrics.widthPixels;
        // 计算偏移量
        Offset = (screenW / mViews.size() - cursorWidth) / 2;
        // 设置动画初始位置
        Matrix matrix = new Matrix();
        matrix.postTranslate(Offset, 0);
        cursor.setImageMatrix(matrix);
    }
}

package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;

public class ChannelActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout titlebar;
    private LinearLayout titlebarPrev;
    private Button literature;
    private Button music;
    private Button dancing;
    private Button theatre;
    private Button quyi;
    private Button acrobatics;
    private Button art;
    private Button tradition;
    private Button medicine;
    private Button folk;
    private LinearLayout channelVideos;
    private LinearLayout channelTopics;
    private LinearLayout choose;
    private LinearLayout index;
    private LinearLayout trends;
    private Button selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        titlebar = (LinearLayout) findViewById(R.id.titlebar);
        titlebarPrev = (LinearLayout) findViewById(R.id.titlebarPrev);
        literature = (Button) findViewById(R.id.literature);
        music = (Button) findViewById(R.id.music);
        dancing = (Button) findViewById(R.id.dancing);
        theatre = (Button) findViewById(R.id.theatre);
        quyi = (Button) findViewById(R.id.quyi);
        acrobatics = (Button) findViewById(R.id.acrobatics);
        art = (Button) findViewById(R.id.art);
        tradition = (Button) findViewById(R.id.tradition);
        medicine = (Button) findViewById(R.id.medicine);
        folk = (Button) findViewById(R.id.folk);
        channelTopics = (LinearLayout) findViewById(R.id.channelTopics);
        channelVideos = (LinearLayout) findViewById(R.id.channelVideos);
        choose = (LinearLayout) findViewById(R.id.channelChooseLL);
        index = (LinearLayout) findViewById(R.id.channelIndex);
        trends = (LinearLayout) findViewById(R.id.channelTrends);

        titlebarPrev.setOnClickListener(this);
        literature.setOnClickListener(this);
        music.setOnClickListener(this);
        dancing.setOnClickListener(this);
        theatre.setOnClickListener(this);
        quyi.setOnClickListener(this);
        acrobatics.setOnClickListener(this);
        art.setOnClickListener(this);
        tradition.setOnClickListener(this);
        medicine.setOnClickListener(this);
        folk.setOnClickListener(this);
        channelTopics.setOnClickListener(this);
        channelVideos.setOnClickListener(this);
        index.setOnClickListener(this);
        trends.setOnClickListener(this);

        titlebar.setBackgroundResource(R.drawable.dingbu);
        titlebarPrev.setBackgroundResource(0);
        titlebarPrev.removeViewAt(0);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.titlebarPrev:
                break;
            case R.id.literature:
            case R.id.music:
            case R.id.dancing:
            case R.id.theatre:
            case R.id.quyi:
            case R.id.acrobatics:
            case R.id.art:
            case R.id.tradition:
            case R.id.medicine:
            case R.id.folk:
                if (selected == null) {
                    view.setBackgroundResource(R.drawable.pao271after);
                    selected = (Button) view;
                    choose.setVisibility(View.VISIBLE);
                } else if (view == selected) {
                    view.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                    choose.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.channelTopics:
                if (selected != null) {
                    Intent intent = new Intent(ChannelActivity.this, TopicsChannel.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                    choose.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.channelVideos:
                if (selected != null) {
                    Intent intent = new Intent(ChannelActivity.this, VideosChannel.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                    choose.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.channelIndex:
                Intent intent1 = new Intent(ChannelActivity.this, IndexActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.channelTrends:
                Intent intent2 = new Intent(ChannelActivity.this, TrendsActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    public void onBackPressed() {       // 当触摸返回键时
        AlertDialog.Builder checkExit = new AlertDialog.Builder(this);      // 创建对话框
        checkExit.setMessage("退出程序？");
        checkExit.setCancelable(true);
        checkExit.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();                                                       // 选“是”则结束当前Activity
            }
        });
        checkExit.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}      // 选“否”对话框消失
        });
        checkExit.show();       // 弹出对话框
    }
}
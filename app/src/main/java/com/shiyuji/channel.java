package com.shiyuji;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.support.v7.app.AppCompatActivity;

import android.widget.Button;

public class channel extends AppCompatActivity implements View.OnClickListener {

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
    private Button shipinqua;
    private Button taolun;
    private Button selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

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
        //右下按钮“视频区”，进入视频区页面
        shipinqua = (Button) findViewById(R.id.shipinqua);
        //左下按钮“讨论区”，进入讨论区页面
        taolun = (Button) findViewById(R.id.taolun);

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
        shipinqua.setOnClickListener(this);
        taolun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
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
                } else if (view == selected) {
                    view.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                }
                break;
            case R.id.shipinqua:
                if (selected != null) {
                    Intent intent = new Intent(channel.this, channel_videoa.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                }
                break;
            case R.id.taolun:
                if (selected != null) {
                    Intent intent = new Intent(channel.this, Trneds.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                }
                break;
        }
    }
}
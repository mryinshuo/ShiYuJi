package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;

public class ChannelActivity extends AppCompatActivity implements View.OnClickListener {

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
    private RadioButton bottom1_zhuye;
    private RadioButton bottom1_dongtai;
    private Button selected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        findViewById(R.id.bottom1_dongtai).setBackgroundResource(R.drawable.dongtaidianjihou);
        findViewById(R.id.bottom1_zhuye).setBackgroundResource(R.drawable.zhuyedianjihou);
        findViewById(R.id.bottom1_pindao).setBackgroundResource(R.drawable.pindaodianjiqian);

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
        shipinqua = (Button) findViewById(R.id.shipinqua);
        taolun = (Button) findViewById(R.id.taolun);
        bottom1_zhuye = (RadioButton) findViewById(R.id.bottom1_zhuye);
        bottom1_dongtai = (RadioButton) findViewById(R.id.bottom1_dongtai);

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
        bottom1_zhuye.setOnClickListener(this);
        bottom1_dongtai.setOnClickListener(this);
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
                    Intent intent = new Intent(ChannelActivity.this, channel_videoa.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                }
                break;
            case R.id.taolun:
                if (selected != null) {
                    Intent intent = new Intent(ChannelActivity.this, Topics.class);
                    intent.putExtra("title", selected.getText());
                    startActivity(intent);
                    selected.setBackgroundResource(R.drawable.pao271);
                    selected = null;
                }
                break;
            case R.id.bottom1_zhuye:
                Intent intent1 = new Intent(ChannelActivity.this, IndexActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.bottom1_dongtai:
                Intent intent2 = new Intent(ChannelActivity.this, UserActivity.class);
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
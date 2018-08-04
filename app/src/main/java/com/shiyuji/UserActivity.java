package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView zhuye;
    private ImageView pindao;
    private ImageView dongtai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        zhuye = (ImageView) findViewById(R.id.bottom1_zhuye);
        pindao = (ImageView) findViewById(R.id.bottom1_pindao);
        dongtai = (ImageView) findViewById(R.id.bottom1_dongtai);

        zhuye.setOnClickListener(this);
        pindao.setOnClickListener(this);

        zhuye.setImageResource(R.drawable.zhuyedianjihou);
        pindao.setImageResource(R.drawable.pindaodianjihou);
        dongtai.setImageResource(R.drawable.dongtaidianjiqian);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom1_zhuye:
                Intent intent1 = new Intent(UserActivity.this, IndexActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.bottom1_pindao:
                Intent intent2 = new Intent(UserActivity.this, ChannelActivity.class);
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

package com.shiyuji;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.hby.shiyuji.R;


public class syj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syj);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称

        //论坛右下add按钮，进入写动态页面
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){//alt+enter 打包
                Intent intent = new Intent(syj.this,Write.class);
                startActivity(intent);
            }
        });
        //进入动态详情
        LinearLayout ln1 =(LinearLayout)findViewById(R.id.ln1);
        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){//alt+enter 打包
                Intent intent = new Intent(syj.this,self_write.class);
                startActivity(intent);
            }
        });

        //论坛左上取消按钮，返回主页
        ImageButton del1 = (ImageButton) findViewById(R.id.del1);
        del1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
        //点赞效果
        final ImageButton zan1 =(ImageButton) findViewById(R.id.zan1);
        zan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = 1;
                if (time % 2 == 1)

                {
                    zan1.setBackgroundResource(R.drawable.like12);


                } else

                {
                    zan1.setBackgroundResource(R.drawable.like11);

                }

                time++;
            }

        });
    }




}

package com.shiyuji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class channel_videoa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_videoa);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");      // 从频道传回的标题名称

        //返回频道页面
        Button like3 = (Button) findViewById(R.id.like3);
        like3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}

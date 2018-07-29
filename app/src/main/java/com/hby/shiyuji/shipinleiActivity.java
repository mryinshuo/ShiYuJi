package com.hby.shiyuji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class shipinleiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipinlei);
    }
//标签跳转该标签非遗文化页面

    public  void feiyibiaoqian (View view){
        Toast.makeText(this,"欢迎浏览该标签",Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this,feiyibiaoqian.class);
        startActivity(intent);
    }
    public  void fanhuishipinyemian(View view){
        Intent intent = new Intent(this,shipinleiActivity.class);
        startActivity(intent);
    }
}

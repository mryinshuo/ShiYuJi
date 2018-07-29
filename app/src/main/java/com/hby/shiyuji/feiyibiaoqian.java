package com.hby.shiyuji;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class feiyibiaoqian extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feiyibiaoqian);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec 官方 = tabHost.newTabSpec("001").setIndicator("官方").setContent(R.id.guanfang);
        TabHost.TabSpec 其他 = tabHost.newTabSpec("002").setIndicator("其他").setContent(R.id.qita);
        tabHost.addTab(官方);
        tabHost.addTab(其他);
    }
    public void fanhuishipinyemian(View view) {

    }
}

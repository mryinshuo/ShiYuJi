package com.shiyuji;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.hby.shiyuji.R;

public class Main3Activity extends TabActivity {

    private RadioButton bottom1_pindao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);

        findViewById(R.id.bottom1_pindao).setBackgroundResource(R.drawable.pindaodianjihou);
        findViewById(R.id.bottom1_dongtai).setBackgroundResource(R.drawable.dongtaidianjihou);
        findViewById(R.id.bottom1_zhuye).setBackgroundResource(R.drawable.zhuyedianjiqian);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec 推荐 = tabHost.newTabSpec("001").setIndicator("推荐").setContent(R.id.page1_tuijian);
        TabHost.TabSpec 直播 = tabHost.newTabSpec("002").setIndicator("直播").setContent(R.id.page2_zhibo);
        TabHost.TabSpec 附近 = tabHost.newTabSpec("003").setIndicator("附近").setContent(R.id.page3_fujin);
        TabHost.TabSpec 其他 = tabHost.newTabSpec("004").setIndicator("其他").setContent(R.id.page4_qita);
        tabHost.addTab(推荐);
        tabHost.addTab(直播);
        tabHost.addTab(附近);
        tabHost.addTab(其他);

        bottom1_pindao = (RadioButton) findViewById(R.id.bottom1_pindao);
        bottom1_pindao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this, channel.class);
                startActivity(intent);
            }
        });
    }
    public void shipinleidianji(View view){
        Toast.makeText(this,"欢迎浏览视频",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,shipinleiActivity.class);
        startActivity(intent);
    }
    public  void fanhuizhuyemian(View view){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }


}


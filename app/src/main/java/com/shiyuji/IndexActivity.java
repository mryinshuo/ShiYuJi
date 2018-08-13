package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.shiyuji.adapter.IndexItemAdapter;
import com.shiyuji.adapter.IndexPagerAdapter;
import com.shiyuji.model.IndexItem;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private List<Integer> page;
    private List<String> title;
    private ViewPager indexVP;
    private ImageView indexDrawer;
    private LinearLayout channel;
    private LinearLayout trends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_drawer);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        indexDrawer = (ImageView) findViewById(R.id.indexDrawerIV);
        channel = (LinearLayout) findViewById(R.id.indexChannel);
        trends = (LinearLayout) findViewById(R.id.indexTrends);

        channel.setOnClickListener(this);
        trends.setOnClickListener(this);
        indexDrawer.setOnClickListener(this);

        init();
        indexVP = (ViewPager) findViewById(R.id.indexVP);
        indexVP.setAdapter(new IndexPagerAdapter(this, page, title));
    }

    public void init() {
        page = new ArrayList<>();
        page.add(R.layout.activity_index_recommend);
        page.add(R.layout.activity_index_live);
        page.add(R.layout.activity_index_nearby);

        title = new ArrayList<>();
        title.add("推荐");
        title.add("直播");
        title.add("附近");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.indexChannel:
                Intent intent1 = new Intent(this, ChannelActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.indexTrends:
                Intent intent2 = new Intent(this, TrendsActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.indexDrawerIV:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.START);
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_settings:
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

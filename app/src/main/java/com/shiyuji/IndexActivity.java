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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.shiyuji.adapter.IndexPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private List<Integer> list;
    private List<String> title;
    private ViewPager indexVP;
    private RadioButton bottom1_pindao;
    private RadioButton bottom1_dongtai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_drawer);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        findViewById(R.id.bottom1_pindao).setBackgroundResource(R.drawable.pindaodianjihou);
        findViewById(R.id.bottom1_dongtai).setBackgroundResource(R.drawable.dongtaidianjihou);
        findViewById(R.id.bottom1_zhuye).setBackgroundResource(R.drawable.zhuyedianjiqian);

        init();
        indexVP = (ViewPager) findViewById(R.id.indexVP);
        indexVP.setAdapter(new IndexPagerAdapter(this, list, title));

        bottom1_pindao = (RadioButton) findViewById(R.id.bottom1_pindao);
        bottom1_dongtai = (RadioButton) findViewById(R.id.bottom1_dongtai);
        bottom1_pindao.setOnClickListener(this);
        bottom1_dongtai.setOnClickListener(this);
    }

    public void init() {
        list = new ArrayList<>();
        list.add(R.layout.activity_index_recommend);
        list.add(R.layout.activity_index_live);
        list.add(R.layout.activity_index_nearby);

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
            case R.id.bottom1_pindao:
                Intent intent1 = new Intent(this, ChannelActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.bottom1_dongtai:
                Intent intent2 = new Intent(this, UserActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_slideshow:
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.shiyuji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.shiyuji.adapter.ContactSettingsItemAdapter;
import com.shiyuji.model.ContactSettingsItem;

import java.util.ArrayList;
import java.util.List;

public class ContactSettings extends AppCompatActivity {

    private List<ContactSettingsItem> itemList = new ArrayList<>();     // 定义一个ArrayList存放所有要添加的item
    private ContactSettingsItemAdapter adapter;
    private ListView contactLV;
    private TextView contactET;         // 输入框
    private Button contactButton;       // 提交按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_contact);

        contactLV = (ListView) findViewById(R.id.contactLV);
        contactET = (TextView) findViewById(R.id.contactET);
        contactButton = (Button) findViewById(R.id.contactButton);
        itemList.add(new ContactSettingsItem(R.mipmap.launcher, "我是客服尹烁，很高兴为您服务", false));      // 设置客服默认消息

        adapter = new ContactSettingsItemAdapter(this, R.layout.settings_contact_item, itemList);    // 声明adapter
        contactLV.setAdapter(adapter);                                                                       // 设置adapter

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!contactET.getText().toString().equals("")) {                                                               // 若消息内容不为空
                    adapter.add(new ContactSettingsItem(R.mipmap.ic_launcher_round, contactET.getText().toString(), true));     // 添加消息至ListView
                    contactET.setText("");                                                                                             // 清空输入框
                }
            }
        });
    }
}

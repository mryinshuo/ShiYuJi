package com.hby.shiyuji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FindPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText findPwUsername;
    private EditText findPwCaptcha;
    private Button findPwButton;
    private TextView find2log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);

        findPwUsername = (EditText) findViewById(R.id.findPwUsername);
        findPwUsername.setOnClickListener(this);
        findPwCaptcha = (EditText) findViewById(R.id.findPwCaptcha);
        findPwCaptcha.setOnClickListener(this);
        findPwButton = (Button) findViewById(R.id.findPwButton);
        findPwButton.setOnClickListener(this);
        find2log = (TextView) findViewById(R.id.find2log);
        find2log.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.findPwButton:         // 找回密码按钮
                String username = findPwUsername.getText().toString();
                String captcha = findPwCaptcha.getText().toString();
                Toast.makeText(this, "账号：" + username + "\n" + "验证码：" + captcha, Toast.LENGTH_SHORT).show();
                break;
            case R.id.find2log:             // 登陆按钮
                finish();
                break;
        }
    }
}

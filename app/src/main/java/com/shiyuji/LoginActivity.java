package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private EditText editTextUn;
    private EditText editTextPw;
    private Button togglePw;
    private Button loginButton;
    private TextView findPw;
    private TextView log2sign;
    private Button setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUn = (EditText) findViewById(R.id.loginUn);
        editTextPw = (EditText) findViewById(R.id.loginPw);
        togglePw = (Button) findViewById(R.id.togglePw);
        togglePw.setOnClickListener(this);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        log2sign = (TextView) findViewById(R.id.log2sign);
        log2sign.setOnClickListener(this);
        findPw = (TextView) findViewById(R.id.findPw);
        findPw.setOnClickListener(this);
        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.togglePw:
                if (togglePw.getText().toString().equals("显示密码")) {                             // 若当前密码为隐藏状态
                    editTextPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());  // 显示密码
                    togglePw.setText("隐藏密码");                                                        // 改变文字
                    editTextPw.setSelection(editTextPw.length());                                       // 将光标移至最后
                } else if (togglePw.getText().toString().equals("隐藏密码")) {                      // 若当前密码为显示状态
                    editTextPw.setTransformationMethod(PasswordTransformationMethod.getInstance());     // 隐藏密码
                    togglePw.setText("显示密码");                                                        // 改变文字
                    editTextPw.setSelection(editTextPw.length());                                       // 将光标移至最后
                }
                break;
            case R.id.loginButton:      // 登录按钮
//                String username = editTextUn.getText().toString();
//                String password = editTextPw.getText().toString();
//                Toast.makeText(this, "账号：" + username + "\n" + "密码：" + password, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                break;
            case R.id.log2sign:         // 注册按钮（login to sign up）
                Intent intent1 = new Intent(this, SignUpActivity.class);
                startActivity(intent1);     // 启动注册Activity
                finish();
                break;
            case R.id.findPw:           // 忘记密码按钮
                Intent intent2 = new Intent(this, FindPasswordActivity.class);
                startActivity(intent2);     // 启动找回密码Activity
                break;                      // 不调用finish()，找回密码页为二级目录，用户须退回一级目录再退出程序
            case R.id.setting:          // 设置按钮
                Intent settings = new Intent(this, Settings.class);
                startActivity(settings);    // 启动设置Activity
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

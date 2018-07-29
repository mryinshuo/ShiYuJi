package com.shiyuji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hby.shiyuji.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUn;
    private EditText editTextPw;
    private EditText editTextPwCh;
    private Button signUpButton;
    private TextView sign2log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUn = (EditText) findViewById(R.id.signUpUsername);
        editTextPw = (EditText) findViewById(R.id.signUpPassword);
        sign2log = (TextView) findViewById(R.id.sign2log);
        sign2log.setOnClickListener(this);
        editTextPwCh = (EditText) findViewById(R.id.signUpCheckPassword);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpButton:     // 注册按钮
                String username = editTextUn.getText().toString();
                String password = editTextPw.getText().toString();
                String checkPassword = editTextPwCh.getText().toString();
                Toast.makeText(this, "账号：" + username + "\n" + "密码：" + password + "\n" + "确认密码：" + checkPassword, Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign2log:         // 登陆按钮（sign up to login）
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);      // 启动登陆Activity
                finish();
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

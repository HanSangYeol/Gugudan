package com.example.the.gugudan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.the.gugudan.Data.User;
import com.example.the.gugudan.Util.GlobalData;

import java.util.List;


public class LoginActivity extends BaseActivity {


    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginBtn;
    private android.widget.TextView findIdBtn;
    private android.widget.TextView findPwBtn;

    List<User> userList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkId = true;
                if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkId = false;
                }
                boolean checkPw = true;
                if (pwEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkPw = false;
                }
                if (checkId && checkPw) {
                    GlobalData.userData();
                    userList = GlobalData.userList;
                    for (User user : GlobalData.userList) {
                        if (idEdt.getText().toString().equals(user.getId())) {
                            if (pwEdt.getText().toString().equals(user.getPw())) {
                                Toast.makeText(mContext, "로그인 완료", Toast.LENGTH_SHORT).show();
                                SignActivity.signActivity.finish();
                                finish();
                            } else {
                                Toast.makeText(mContext, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        } else {
                            Toast.makeText(mContext, "존재하지않는 아이디입니다", Toast.LENGTH_SHORT).show();
                            break;
                        }

                    }


                }
            }
        });

    }

    @Override
    public void setValues() {


    }

    @Override
    public void bindView() {
        this.findPwBtn = (TextView) findViewById(R.id.findPwBtn);
        this.findIdBtn = (TextView) findViewById(R.id.findIdBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}

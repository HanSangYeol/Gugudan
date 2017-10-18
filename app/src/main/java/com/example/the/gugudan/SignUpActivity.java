package com.example.the.gugudan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkId = true;
                if (idEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkId = false;
                }
                boolean checkPw = true;
                if (idEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkPw = false;
                }
                boolean checkName = true;
                if (idEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkName = false;
                }
                if (checkId && checkPw & checkName){
                    Toast.makeText(mContext, "회원가입 완료", Toast.LENGTH_SHORT).show();
                    SignActivity.signActivity.finish();
                    finish();
                }
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}

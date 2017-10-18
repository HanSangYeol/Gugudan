package com.example.the.gugudan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignActivity extends BaseActivity {

    public static SignActivity signActivity;

    private android.widget.Button loginBtn;
    private android.widget.Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        signActivity = this;
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mContext, LoginActivity.class);
                startActivity(myIntent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mContext, SignUpActivity.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);

    }
}

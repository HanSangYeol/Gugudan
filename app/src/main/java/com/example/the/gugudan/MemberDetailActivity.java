package com.example.the.gugudan;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MemberDetailActivity extends BaseActivity {

    private android.widget.TextView countTxt;
    private android.widget.TextView nameTxt;
    private android.widget.TextView positionTxt;
    private android.widget.TextView birthdayTxt;
    private android.widget.TextView ageTxt;
    private android.widget.TextView bloodTypeTxt;

    int age = 0;
    String name;
    String nickName;
    String groupPosition;
    String position;
    String profile;
    Calendar birthday;
    private android.widget.ImageView profileImg;
    private TextView nickNameTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        age = getIntent().getIntExtra("나이", 0);
        name = getIntent().getStringExtra("이름");
        nickName = getIntent().getStringExtra("닉네임");
        groupPosition = getIntent().getStringExtra("단");
        position = getIntent().getStringExtra("포지션");
        profile = getIntent().getStringExtra("사진");
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        Glide.with(mContext).load(profileImg).into(profileImg);
        ageTxt.setText(age + "");
        nameTxt.setText(name);
        nickNameTxt.setText(nickName);
        countTxt.setText(groupPosition);
        positionTxt.setText(position);



    }

    @Override
    public void bindView() {
        this.bloodTypeTxt = (TextView) findViewById(R.id.bloodTypeTxt);
        this.ageTxt = (TextView) findViewById(R.id.ageTxt);
        this.birthdayTxt = (TextView) findViewById(R.id.birthdayTxt);
        this.positionTxt = (TextView) findViewById(R.id.positionTxt);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);
        this.nickNameTxt = (TextView) findViewById(R.id.nickNameTxt);
        this.countTxt = (TextView) findViewById(R.id.countTxt);
        this.profileImg = (ImageView) findViewById(R.id.profileImg);
    }
}

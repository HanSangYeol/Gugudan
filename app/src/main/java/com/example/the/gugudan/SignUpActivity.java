package com.example.the.gugudan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.the.gugudan.Data.User;
import com.example.the.gugudan.Util.ContextUtil;
import com.example.the.gugudan.Util.GlobalData;

import java.util.List;

public class SignUpActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.Button signupBtn;

    List<User> userList = null;

    User signupUser = null;

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
                if (pwEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkPw = false;
                }
                boolean checkName = true;
                if (nameEdt.getText().toString().equals("")){
                    Toast.makeText(mContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkName = false;
                }
                if (checkId && checkPw & checkName){
                    // 비교하려는 User데이터 생성(현재 가입하려는 아이디)
                    signupUser = new User(idEdt.getText().toString(),
                                    pwEdt.getText().toString(), nameEdt.getText().toString());
                    // User 데이터에서 오버라이드한 equals를 contains가 사용하여
                    // 만약 GlobalData.userList가 가지고있는 id중에 비교하려는 signUser의 아이디와 같은게 있다면
                    if (GlobalData.userList.contains(signupUser)){
                        Toast.makeText(mContext, "이미 사용중이 아이디입니다", Toast.LENGTH_SHORT).show();
                    }else {
                        // 아니라면 GlobalData.userList에 추가
                        GlobalData.userList.add(signupUser);
                        Toast.makeText(mContext, "회원가입 완료\n자동 로그인되었습니다", Toast.LENGTH_SHORT).show();
                        SignActivity.signActivity.finish();
                        ContextUtil.login(mContext, signupUser);
                        finish();
                    }

//                    for (User user : GlobalData.userList){
//                        if (!idEdt.getText().toString().equals(user.getId())){
//                            signupUser = new User(idEdt.getText().toString(),
//                                    pwEdt.getText().toString(), nameEdt.getText().toString());
//                            GlobalData.userList.add(signupUser);
//                            Toast.makeText(mContext, "회원가입 완료\n자동 로그인되었습니다", Toast.LENGTH_SHORT).show();
//                            SignActivity.signActivity.finish();
//                            ContextUtil.login(mContext, signupUser);
//                            finish();
//                            break;
//                        }else {
//                            Toast.makeText(mContext, "이미 사용중이 아이디입니다", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                    }

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

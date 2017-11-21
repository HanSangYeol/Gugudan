package com.sy_studio.the.gugudan_SangYeol;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sy_studio.the.gugudan_SangYeol.Data.User;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;
import com.sy_studio.the.gugudan_SangYeol.Util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class LoginActivity extends BaseActivity {


    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.Button loginBtn;
    private android.widget.TextView findIdBtn;
    private android.widget.TextView findPwBtn;

    List<User> userList = null;
    User loginUser = null;


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
//                    loginUser = new User(idEdt.getText().toString(), pwEdt.getText().toString(), "");
//                    if (GlobalData.userList.equals(loginUser)) {
//                        Toast.makeText(mContext, "존재하지않는 아이디입니다", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(mContext, "로그인 완료", Toast.LENGTH_SHORT).show();
//                        SignActivity.signActivity.finish();
//                        finish();
//                    }
                    ServerUtil.login(mContext, idEdt.getText().toString(), pwEdt.getText().toString(),
                            new ServerUtil.JsonResponseHandler() {
                                @Override
                                public void onResponse(JSONObject json) {
                                    try {
                                        Log.d("user", json.getJSONArray("user").toString());

                                        JSONArray jsonArray = json.getJSONArray("user");

                                        for (int i=0; i<jsonArray.length(); i++){
                                            JSONObject user = jsonArray.getJSONObject(i);
                                            User tempUser = User.getUserFromJsonObject(user);

                                            if (idEdt.getText().toString().equals(tempUser.getId())) {
                                                if (pwEdt.getText().toString().equals(tempUser.getPw())) {
                                                    Toast.makeText(mContext, "로그인 완료", Toast.LENGTH_SHORT).show();
                                                    ContextUtil.login(mContext, tempUser);
                                                    SignActivity.signActivity.finish();
                                                    finish();
                                                    break;
                                                } else {
                                                    Toast.makeText(mContext, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                                                    break;
                                                }
                                            } else {
                                                Toast.makeText(mContext, "존재하지않는 아이디입니다", Toast.LENGTH_SHORT).show();
                                                break;
                                            }
                                        }


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });



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

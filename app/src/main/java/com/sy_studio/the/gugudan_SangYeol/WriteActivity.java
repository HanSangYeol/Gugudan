package com.sy_studio.the.gugudan_SangYeol;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sy_studio.the.gugudan_SangYeol.Data.Post;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;

public class WriteActivity extends BaseActivity {

    private android.widget.ImageView cancleBtn;
    private android.widget.TextView confirmBtn;
    private android.widget.EditText titleEdt;
    private android.widget.EditText contentEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkTitle = true;
                if (titleEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "제목을 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkTitle = false;
                }
                boolean checkContent = true;
                if (contentEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                    checkContent = false;
                }
                if (checkTitle && checkContent){
                    GlobalData.postList.add(new Post(titleEdt.getText().toString(), contentEdt.getText().toString()));
                    Toast.makeText(mContext, "게시글 작성 완료", Toast.LENGTH_SHORT).show();
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
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.titleEdt = (EditText) findViewById(R.id.titleEdt);
        this.confirmBtn = (TextView) findViewById(R.id.confirmBtn);
        this.cancleBtn = (ImageView) findViewById(R.id.cancleBtn);
    }
}

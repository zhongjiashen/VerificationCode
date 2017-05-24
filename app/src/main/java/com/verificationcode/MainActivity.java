package com.verificationcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.verificationcode.custom_view.CheckUtil;
import com.verificationcode.custom_view.CheckView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CheckView mCheckView ;
    private Button mSubmit;
    private EditText mEditPass;
    // 验证码：
    private int [] checkNum =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckView = (CheckView) findViewById(R.id.CheckView);
        mCheckView.setOnClickListener(this);
        mEditPass = (EditText) findViewById(R.id.ed_text);
        mSubmit = (Button) findViewById(R.id.bt_ok);
        mSubmit.setOnClickListener(this);
        initCheckNum();
    }
    // 初始化验证码并且刷新界面
    public void initCheckNum(){
        checkNum = CheckUtil.getCheckNum();
        mCheckView.setCheckNum(checkNum);
        mCheckView.invaliChenkNum();
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_ok:
                String userInput = mEditPass.getText().toString();
                if(CheckUtil.checkNum(userInput, checkNum)){

                    Toast.makeText(this, "通过", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(this, "未通过", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.CheckView:
                initCheckNum();
            default:
                break;
        }
    }
}

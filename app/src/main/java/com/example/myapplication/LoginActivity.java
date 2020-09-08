package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.myapplication.R;
import com.example.myapplication.views.InputView;
import com.example.myapplication.utils.UserUtils;


//NavigationBar
public class LoginActivity extends BaseActivity {

    private InputView mInputPhone,mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化View
     */
    private  void initView(){
        initNavBar(false,"登录",false);

        mInputPhone=fd(R.id.input_phone);
        mInputPassword=fd(R.id.input_password);
    }

    //注册页面
    public void onRegisterClick(View v){
            Intent intent=new Intent(this,RegisterActivity.class);
            startActivity(intent);

    }

    /**
     * 登录
     */
    public void onCommitClick(View v){
        String phone=mInputPhone.getInputStr();
        String password=mInputPassword.getInputStr();
//        //验证用户输入是否合法
//        if(!UserUtils.validateLogin(this,phone,password)) {
//            return;
//        }
        //验证成功 跳转到主界面
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}

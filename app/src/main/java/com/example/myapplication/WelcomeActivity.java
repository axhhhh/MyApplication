package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }
    //初始化列表
    private void init(){
        mTimer=new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
//                Log.e("WelcomeActivity","当前线程为："+ Thread.currentThread());
//            toMain();
            toLogin();
            }
        },3*1000);
    }
//跳转到主界面MainActivity
private void toMain(){
    Intent intent=new Intent(this,MainActivity.class);
    startActivity(intent);
finish();
}
//跳转到注册界面LoginActivity
    private void toLogin(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}



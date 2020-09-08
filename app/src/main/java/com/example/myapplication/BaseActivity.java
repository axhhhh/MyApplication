package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

public class BaseActivity extends Activity {
    private ImageView mIvBack,mIvMe;
    private TextView mTvTitle;

//接收一个资源文件的id @IdRes  返回一个T  T是View的子类  findViewById
    protected <T extends View> T fd (@IdRes int id){
        return findViewById(id);
    }
    //初始化NavigationBar
    protected void initNavBar(boolean isShowBack,String title,boolean isShowMe){
        mIvBack=fd(R.id.iv_back);
        mTvTitle=fd(R.id.tv_title);
        mIvMe=fd(R.id.iv_me);
//isShowBack为真时显示，false则不显示
        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });

        }

}

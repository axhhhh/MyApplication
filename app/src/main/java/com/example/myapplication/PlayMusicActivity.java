package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {
    private ImageView mIvBg;
    private PlayMusicView mPlayMusicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        //隐藏statusBar
     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        initView();
    }
    private  void initView(){
    mIvBg=fd(R.id.iv_bg);
//glide-transformations
        Glide.with(this)
                .load("https://img3.sycdn.imooc.com/593d5ae80001fe5101000100-140-140.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,10)))
                .into(mIvBg);
        mPlayMusicView=fd(R.id.play_music_view);
        mPlayMusicView.setMusicIcon("https://img3.sycdn.imooc.com/593d5ae80001fe5101000100-140-140.jpg");
        mPlayMusicView.playMusic("http://music.163.com/song/media/outer/url?id=1463168014.mp3");
    }
    /**
     * 后退按钮
     */
    public void onBackClick(View view){
        onBackPressed();


    }
}
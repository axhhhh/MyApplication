package com.example.myapplication.views;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import helps.MediaPlayerHelp;

public class PlayMusicView extends FrameLayout {
    private Context mContext;
    private boolean isPlaying;
    private String mPath;
    private View mView;
    private MediaPlayerHelp mMediaPlayerHelp;
    private ImageView mIvIcon,mIvNeedle,mIvPlay;
    private FrameLayout mFlPlayMusic;
    private Animation mPlayMusicAnim,mPlayNeedleAnim,mStopNeedleAnim;
    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);

    }
    private void init(Context context){
    mContext=context;
        mView= LayoutInflater.from(mContext).inflate(R.layout.play_music,this,false);
        mFlPlayMusic=mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                trigger();
            }
        });
        mIvIcon=mView.findViewById(R.id.iv_icon);
        mIvNeedle = mView.findViewById(R.id.iv_needle);
        mIvPlay=mView.findViewById(R.id.iv_play);
        /**
         *  1、定义所需要执行的动画
         *      1、光盘转动的动画
         *      2、指针指向光盘的动画
         *      3、指针移开光盘的动画
         *  2、startAnimation
         *
         */
        mPlayMusicAnim=AnimationUtils.loadAnimation(mContext,R.anim.play_music_anim);
        mPlayNeedleAnim=AnimationUtils.loadAnimation(mContext,R.anim.play_needle_anim);
        mStopNeedleAnim=AnimationUtils.loadAnimation(mContext,R.anim.stop_needle_anim);

        addView(mView);
        mMediaPlayerHelp=MediaPlayerHelp.getInstance(mContext);

    }
    /**
     * 切换播放状态
     */
    private void trigger () {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path){
        mPath=path;
        isPlaying = true;
        mIvPlay.setVisibility(View.GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvNeedle.startAnimation(mPlayNeedleAnim);
/**
 * 1、判断当前音乐是否是已经在播放的音乐
 * 2、如果是已在播放的音乐，那么直接执行start方法
 * 3、如果当前播放的不是当前播放的音乐 那么调用setPath方法
 */
        if(mMediaPlayerHelp.getPath()!=null  && mMediaPlayerHelp.getPath().equals(path)){

            mMediaPlayerHelp.start();
        }
        else {
            mMediaPlayerHelp.setPath(path);
            mMediaPlayerHelp.setOnMeidaPlayerHelperListener(new MediaPlayerHelp.OnMeidaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayerHelp.start();
                }

                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

//        启动服务
//        startMusicService();
        }
    /**
     * 停止播放
     */
    public void stopMusic () {
        isPlaying = false;
        mIvPlay.setVisibility(View.VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);
        mMediaPlayerHelp.pause();
//        mMusicBinder.stopMusic();
    }
    /**
     * 设置光盘上显示的音乐封面图片
     */
    public void setMusicIcon(String icon){
        Glide.with(mContext)
            .load(icon)
                .into(mIvIcon);

    }
}

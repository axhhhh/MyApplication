package com.example.myapplication;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.MusicGridAdapter;
import com.example.myapplication.adapters.MusicListAdapter;
import com.example.myapplication.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {



    private RecyclerView mRvGrid,mRvList;
    private MusicGridAdapter mAdapter;
    private MusicListAdapter mListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private  void initView(){
            initNavBar(false,"慕课音乐",true);

            mRvGrid=fd(R.id.rv_grid);
            mRvGrid.setLayoutManager(new GridLayoutManager(this,3));//同一行显示三个元素


        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize),mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);
        mAdapter=new MusicGridAdapter(this);
        mRvGrid.setAdapter(mAdapter);
        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
        */
        mRvList=fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
       mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);

        mListAdapter=new MusicListAdapter(this,mRvList);
        mRvList.setAdapter(mListAdapter);
    }


}
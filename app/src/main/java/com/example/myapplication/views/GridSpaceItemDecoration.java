package com.example.myapplication.views;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    public GridSpaceItemDecoration (int space,RecyclerView parent){
        mSpace=space;
        getRecyclerViewOffsets(parent);

        }

    /**
     *
     * @param outRect  Item的矩形边界
     * @param view  ItemView
     * @param parent  RecyclerView
     * @param state  RecyclerView的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //通过偏移来实现中间的分割线 宽和高相等
        outRect.left=mSpace;

        //判断Item是不是每一行第一个Item 可以实现分割线 但由于偏移量=0则长==宽>其他网格的长度
//        if(parent.getChildAdapterPosition(view) %3==0){
//            outRect.left=0;
//
//        }
//
    }
        private  void getRecyclerViewOffsets(RecyclerView parent){
            //view margin
//        margin 为 正 ，则 view会距离边界产生一个距离
//        margin  为  负  ，则view会超出边界产生一个距离
            LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams) parent.getLayoutParams();
            layoutParams.leftMargin=-mSpace;
            parent.setLayoutParams(layoutParams);

        }
}

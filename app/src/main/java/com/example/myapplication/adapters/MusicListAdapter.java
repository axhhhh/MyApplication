package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.PlayMusicActivity;
import com.example.myapplication.R;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {
    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    public MusicListAdapter(Context context,RecyclerView recyclerView){
        mContext=context;
        mRv=recyclerView;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mItemView=LayoutInflater.from(mContext).inflate(R.layout.item_list_music,parent,false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setRecyclerViewHeight();
        Glide.with(mContext)
//                .load()
                .load("https://img3.sycdn.imooc.com/593d5ae80001fe5101000100-140-140.jpg")
              .into(holder.ivIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }
    /**
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、使用 itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight(){
        if (isCalcaulationRvHeight || mRv==null)  return;
        isCalcaulationRvHeight=true;
//        获取ItemView的高度
        RecyclerView.LayoutParams itemViewlp=(RecyclerView.LayoutParams) mItemView.getLayoutParams();
//          itemView的数量
        int itemCount=getItemCount();
//        使用 itemViewHeight * itemViewNum = RecyclerView的高度
        int recyclerViewHeight=itemViewlp.height*itemCount;
//        设置RecyclerView高度
        LinearLayout.LayoutParams rvlp=(LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvlp.height=recyclerViewHeight;
        mRv.setLayoutParams(rvlp);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView ivIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            ivIcon=itemView.findViewById(R.id.iv_icon);
        }
    }
    }

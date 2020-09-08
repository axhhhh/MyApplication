package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.myapplication.AlbumListActivity;
import com.example.myapplication.R;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder>{

    private Context mContext;
    public MusicGridAdapter (Context context){
        mContext=context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate
                (R.layout.item_grid_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .load("https://img3.sycdn.imooc.com/593d5ae80001fe5101000100-140-140.jpg")
                .into(holder.ivIcon);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext, AlbumListActivity.class);
                    mContext.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return 6;   //个数
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivIcon;
        View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            ivIcon=itemView.findViewById(R.id.iv_icon);
        }
    }

    }


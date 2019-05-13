package com.example.price_this.price_this;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewPicture;
        TextView txtViewPrice;
        TextView txtViewGoodsName;

        MyViewHolder(View view){
            super(view);
            imgViewPicture = view.findViewById(R.id.imgViewPicture);
            txtViewPrice = view.findViewById(R.id.txtViewPrice);
            txtViewGoodsName = view.findViewById(R.id.txtViewName);
        }
    }

    private ArrayList<GoodsInfo> goodsInfoArrayList;
    MyAdapter(ArrayList<GoodsInfo> goodsInfoArrayList){
        this.goodsInfoArrayList = goodsInfoArrayList;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.imgViewPicture.setImageResource(goodsInfoArrayList.get(position).goodsPicture);
        myViewHolder.txtViewPrice.setText(goodsInfoArrayList.get(position).goodsPrice);
        myViewHolder.txtViewGoodsName.setText(goodsInfoArrayList.get(position).goodsName);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Toast.makeText(context, "이거는 "+goodsInfoArrayList.get(position).goodsName+ "이야 으아악 누르지마", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsInfoArrayList.size();
    }
}
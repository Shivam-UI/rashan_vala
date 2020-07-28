package com.lgt.Adaper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.Interface.HomeSliderInterface;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ISHolder> {

    Context mContext;
    Integer[] mList;
    HomeSliderInterface mHomeSliderInterface;

    public ImageSliderAdapter(Context mContext, Integer[] mList,HomeSliderInterface mHomeSliderInterface) {
        this.mContext = mContext;
        this.mList = mList;
        this.mHomeSliderInterface = mHomeSliderInterface;
    }

    @NonNull
    @Override
    public ISHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.image_slider_adapter,parent,false);
        return new ISHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ISHolder holder, final int position) {
        Log.d("slider_size",""+mList.length);
        holder.iv_single_product_slider_images.setImageResource(mList[position]);
        if (mList.length > 3){
            if (position == 4){
                holder.iv_single_product_slider_images.setVisibility(View.GONE);
                holder.tv_item_extra_count.setVisibility(View.VISIBLE);
            }
        }else{
            holder.tv_item_extra_count.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHomeSliderInterface.sliderImageFound(mList[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.length;
    }

    public class ISHolder extends RecyclerView.ViewHolder{
        ImageView iv_single_product_slider_images;
        TextView tv_item_extra_count;
        public ISHolder(@NonNull View itemView) {
            super(itemView);
            iv_single_product_slider_images = itemView.findViewById(R.id.iv_single_product_slider_images);
            tv_item_extra_count = itemView.findViewById(R.id.tv_item_extra_count);
        }
    }
}

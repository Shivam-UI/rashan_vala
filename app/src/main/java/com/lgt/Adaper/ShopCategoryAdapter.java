package com.lgt.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.SCHolder> {

    Context mContext;
    ArrayList<String> mList;

    public ShopCategoryAdapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public SCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_items,parent,false);
        return new SCHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SCHolder holder, int position) {
        holder.tv_category_name.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class SCHolder extends RecyclerView.ViewHolder {
        TextView tv_category_name;
        public SCHolder(@NonNull View itemView) {
            super(itemView);
            tv_category_name =itemView.findViewById(R.id.tv_category_name);
        }
    }
}

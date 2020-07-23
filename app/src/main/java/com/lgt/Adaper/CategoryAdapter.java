package com.lgt.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lgt.Model.CategoryModel;
import com.lgt.rashanwala.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateHolder> {

    Context mContext;
    ArrayList<Integer> mList;
    ArrayList<String> mNameList;
    LayoutInflater layoutInflater;

    public CategoryAdapter(Context mContext, ArrayList<Integer> list,ArrayList<String> namelist) {
        this.mContext = mContext;
        this.mList = list;
        this.mNameList = namelist;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public CateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.category_list_items, parent, false);
        return new CateHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CateHolder holder, int position) {
        holder.iv_category_icon.setImageResource(mList.get(position));
        holder.tv_name_category.setText(mNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CateHolder extends RecyclerView.ViewHolder {
        CardView cv_category_item;
        ImageView iv_category_icon;
        TextView tv_name_category;
        public CateHolder(@NonNull View itemView) {
            super(itemView);
            cv_category_item = itemView.findViewById(R.id.cv_category_item);
            iv_category_icon = itemView.findViewById(R.id.iv_category_icon);
            tv_name_category = itemView.findViewById(R.id.tv_name_category);
        }
    }
}

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

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreHolder> {

    Context mContext;
    ArrayList<String> list;
    LayoutInflater layoutInflater;

    public StoreAdapter(Context mContext, ArrayList<String> list) {
        this.mContext = mContext;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.single_store_list, parent, false);
        return new StoreHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreHolder holder, int position) {
        holder.tv_store_name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StoreHolder extends RecyclerView.ViewHolder{
        TextView tv_store_name;
        public StoreHolder(@NonNull View itemView) {
            super(itemView);
            tv_store_name = itemView.findViewById(R.id.tv_store_name);
        }
    }
}

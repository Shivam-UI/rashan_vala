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

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.PurchaseHolder> {

    Context mContext;
    ArrayList<String> mList;

    public PurchaseAdapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PurchaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.purchase_list_item, parent, false);
        return new PurchaseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseHolder holder, int position) {
        holder.tv_product_name.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class PurchaseHolder extends RecyclerView.ViewHolder{
        TextView tv_purchase_result,tv_product_name;
        public PurchaseHolder(@NonNull View itemView) {
            super(itemView);
            tv_purchase_result = itemView.findViewById(R.id.tv_purchase_result);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
        }
    }
}

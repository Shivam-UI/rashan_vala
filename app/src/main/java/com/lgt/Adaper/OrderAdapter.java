package com.lgt.Adaper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    Context mContext;
    ArrayList<String> mList;
    ArrayList<String> mStatusList;

    public OrderAdapter(Context mContext, ArrayList<String> mList, ArrayList<String> mStatus) {
        this.mContext = mContext;
        this.mList = mList;
        this.mStatusList = mStatus;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.order_list_items, parent, false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        holder.tv_order_product_name.setText(mList.get(position));
        if (mStatusList.get(position) == "P") {
            holder.tv_product_status.setText("Pending");
            holder.iv_check.setVisibility(View.VISIBLE);
            holder.iv_uncheck.setVisibility(View.GONE);
            holder.tv_product_status.setTextColor(Color.GREEN);
        } else if (mStatusList.get(position) == "D") {
            holder.iv_check.setVisibility(View.VISIBLE);
            holder.iv_uncheck.setVisibility(View.GONE);

            holder.tv_product_status.setText("Delivered");
            holder.tv_product_status.setTextColor(Color.GREEN);
            holder.iv_check.setVisibility(View.VISIBLE);
            holder.iv_check.setImageResource(R.drawable.ic_product_deliver);
            holder.iv_uncheck.setVisibility(View.GONE);
        } else if (mStatusList.get(position) == "C") {
            holder.iv_check.setVisibility(View.GONE);
            holder.iv_uncheck.setVisibility(View.VISIBLE);
            holder.tv_product_status.setText("Cancel");
            holder.tv_product_status.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder {
        TextView tv_order_product_name, tv_product_status;
        ImageView iv_check, iv_uncheck;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            tv_order_product_name = itemView.findViewById(R.id.tv_order_product_name);
            tv_product_status = itemView.findViewById(R.id.tv_product_status);
            iv_check = itemView.findViewById(R.id.iv_check);
            iv_uncheck = itemView.findViewById(R.id.iv_uncheck);
        }
    }
}

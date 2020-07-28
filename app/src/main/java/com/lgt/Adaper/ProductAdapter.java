package com.lgt.Adaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    Context mContext;
    ArrayList<String> list;

    public ProductAdapter(Context contextl, ArrayList<String> list) {
        this.mContext = contextl;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_item_list, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.tv_product_name.setText(list.get(position));
        holder.iv_share_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareApp(mContext);
            }
        });
    }

    public static void shareApp(Context context)
    {
        final String appPackageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out the Latest Product ");
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder{
        TextView tv_product_name;
        ImageView iv_share_product;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            iv_share_product = itemView.findViewById(R.id.iv_share_product);
        }
    }
}

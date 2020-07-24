package com.lgt.Adaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.Model.ProductModel;
import com.lgt.rashanwala.R;
import com.lgt.rashanwala.SingleProductActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeItemHolder> {

    Context mContext;
    List<ProductModel> mList;
    LayoutInflater layoutInflater;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater=LayoutInflater.from(mContext);
    }

    public HomeAdapter(Context mContext, List<ProductModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public HomeItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.product_list_items, parent, false);

        return new HomeItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeItemHolder holder, int position) {
        holder.iv_product_image.setImageResource(mList.get(position).image);
        holder.ll_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent product = new Intent(mContext, SingleProductActivity.class);
                mContext.startActivity(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class HomeItemHolder extends RecyclerView.ViewHolder {
        TextView tv_product_name;
        ImageView iv_product_image;
        LinearLayout ll_add_to_cart;
        public HomeItemHolder(@NonNull View itemView) {
            super(itemView);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            iv_product_image = itemView.findViewById(R.id.iv_product_image);
            ll_add_to_cart = itemView.findViewById(R.id.ll_add_to_cart);
        }
    }
}

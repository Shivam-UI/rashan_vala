package com.lgt.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.rashanwala.ProflieActivity;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ProductOfferAdapter extends RecyclerView.Adapter<ProductOfferAdapter.ProductOfferHolder> {

    Context mContext;
    ArrayList<String> mList;

    public ProductOfferAdapter(Context mcontext, ArrayList<String> mList) {
        this.mContext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ProductOfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.offer_list_items,parent,false);
        return new ProductOfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductOfferHolder holder, int position) {
        holder.tv_offer_product.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ProductOfferHolder extends RecyclerView.ViewHolder{
        TextView tv_offer_product;
        public ProductOfferHolder(@NonNull View itemView) {
            super(itemView);
            tv_offer_product = itemView.findViewById(R.id.tv_offer_product);
        }
    }
}

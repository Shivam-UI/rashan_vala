package com.lgt.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.rashanwala.R;
import com.lgt.rashanwala.SingleProductActivity;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    int Count = 1;
    Context mContext;
    ArrayList<String> list;

    public CartAdapter(Context mContext, ArrayList<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cart_list_items, parent, false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartHolder holder, int position) {
        holder.tv_cart_product_name.setText(list.get(position));
        holder.iv_cart_add_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Count == 1) {
                    Count++;
                    holder.tv_cart_counter_text.setText("" + Count);
                } else {
                    Count++;
                    holder.tv_cart_counter_text.setText("" + Count);
                }
            }
        });
        holder.iv_cart_remove_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Count > 1) {
                    Count--;
                    holder.tv_cart_counter_text.setText("" + Count);
                } else if (Count == 1) {
                    Toast.makeText(mContext, "Need at list one item.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        TextView tv_cart_product_name, tv_cart_counter_text;
        ImageView iv_cart_add_count, iv_cart_remove_count;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            tv_cart_product_name = itemView.findViewById(R.id.tv_cart_product_name);
            tv_cart_counter_text = itemView.findViewById(R.id.tv_cart_counter_text);
            iv_cart_add_count = itemView.findViewById(R.id.iv_cart_add_count);
            iv_cart_remove_count = itemView.findViewById(R.id.iv_cart_remove_count);
        }
    }
}

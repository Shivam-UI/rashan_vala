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

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {

    Context mContext;
    ArrayList<String> mList;
    LayoutInflater layoutInflater;

    public ReviewAdapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.single_review_list, parent, false);
        return new ReviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        holder.tv_review_title.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ReviewHolder extends RecyclerView.ViewHolder{
        TextView tv_review_title,tv_review_description;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_review_title = itemView.findViewById(R.id.tv_review_title);
            tv_review_description = itemView.findViewById(R.id.tv_review_description);
        }
    }
}

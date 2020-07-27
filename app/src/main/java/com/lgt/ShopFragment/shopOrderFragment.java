package com.lgt.ShopFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.Adaper.OrderAdapter;
import com.lgt.Adaper.ProductAdapter;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class shopOrderFragment extends Fragment {
    RecyclerView rv_order_details;
    ArrayList<String> productList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_order_fragment, container, false);
        // init
        rv_order_details = view.findViewById(R.id.rv_order_details);
        // layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_order_details.hasFixedSize();
        rv_order_details.setLayoutManager(layoutManager);
        // init Data
        setRecentProductAdapter();
        return view;
    }

    private void setRecentProductAdapter() {
        productList.add("Whole wheat bread");
        productList.add("Pita pockets");
        productList.add("English muffins");
        productList.add("Whole-grain");
        productList.add("Flour tortillas");
        productList.add("Ground turkey");
        OrderAdapter orderAdapter = new OrderAdapter(getContext(), productList);
        rv_order_details.setAdapter(orderAdapter);
    }
}

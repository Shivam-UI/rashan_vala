package com.lgt.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.lgt.Adaper.HomeAdapter;
import com.lgt.Adaper.SlidingImage_Adapter;
import com.lgt.Adaper.StoreAdapter;
import com.lgt.Model.ProductModel;
import com.lgt.rashanwala.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StoreFragment extends Fragment {
    // setup menu
    RecyclerView rv_store_name_list;
    StoreAdapter storeAdapter;
    ArrayList<String> mList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_layout, container, false);
        // init
        rv_store_name_list = view.findViewById(R.id.rv_store_name_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_store_name_list.hasFixedSize();
        rv_store_name_list.setLayoutManager(layoutManager);
        // init store list
        initStoreList();
        return view;
    }

    private void initStoreList() {
        mList = new ArrayList<>();
        mList.add("Sabzi Vala");
        mList.add("Grocery Store Okhla");
        mList.add("Grocery & More");
        mList.add("Saaria Super Store");
        mList.add("Grocery & More");
        mList.add("Green Apple Grocery");
        storeAdapter = new StoreAdapter(getContext(),mList);
        rv_store_name_list.setAdapter(storeAdapter);
    }
}

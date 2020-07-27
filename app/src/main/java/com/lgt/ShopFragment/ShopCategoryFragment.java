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

import com.lgt.Adaper.OfferAdapter;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ShopCategoryFragment extends Fragment {

    RecyclerView rv_category_list;
    OfferAdapter offerAdapter;
    ArrayList<String> mList;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_category_fragment, container, false);
        // init
        rv_category_list = view.findViewById(R.id.rv_category_list);
        // set Layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_category_list.hasFixedSize();
        rv_category_list.setLayoutManager(layoutManager);
        // set Adapter
        setCategoryAdapter();
        return view;
    }

    private void setCategoryAdapter() {
        mList = new ArrayList<>();
        mList.add("Fresh Vegetables");
        mList.add("Fresh Fruits");
        mList.add("Easy BreakFast Snack");
        offerAdapter = new OfferAdapter(getContext(),mList);
        rv_category_list.setAdapter(offerAdapter);
    }

}

package com.lgt.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.Adaper.OfferAdapter;
import com.lgt.Adaper.ProductOfferAdapter;
import com.lgt.Adaper.PurchaseAdapter;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class OfferFragment extends Fragment {

    ArrayList<String> mList;
    ProductOfferAdapter offerAdapter;
    RecyclerView rv_offer_list;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offer_fragment, container, false);
        // init
        rv_offer_list = view.findViewById(R.id.rv_offer_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        rv_offer_list.hasFixedSize();
        // rv_offer_list.setLayoutManager(layoutManager);
        rv_offer_list.setLayoutManager(new GridLayoutManager(getContext(),2));
        initStoreList();
        return view;
    }

    private void initStoreList() {
        mList = new ArrayList<>();
        mList.add("25% OFF");
        mList.add("15% OFF");
        mList.add("35% OFF");
        mList.add("55% OFF");
        mList.add("5% OFF");
        mList.add("45% OFF");
        mList.add("10% OFF");
        mList.add("75% OFF");

        offerAdapter = new ProductOfferAdapter(getContext(),mList);
        rv_offer_list.setAdapter(offerAdapter);
    }
}

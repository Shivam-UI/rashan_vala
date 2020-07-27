package com.lgt.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lgt.Adaper.PurchaseAdapter;
import com.lgt.Adaper.StoreAdapter;
import com.lgt.rashanwala.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView rv_purchase_history;
    ArrayList<String> mList;
    PurchaseAdapter purchaseAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        // init
        rv_purchase_history = view.findViewById(R.id.rv_purchase_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rv_purchase_history.hasFixedSize();
        rv_purchase_history.setLayoutManager(layoutManager);
        initStoreList();
        return view;
    }

    private void initStoreList() {
        mList = new ArrayList<>();
        mList.add("Fast Food");
        mList.add("Quest Food");
        mList.add("Healthy Snack");

        purchaseAdapter = new PurchaseAdapter(getContext(),mList);
        rv_purchase_history.setAdapter(purchaseAdapter);
    }
}

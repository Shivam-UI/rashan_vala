package com.lgt.ShopFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lgt.Adaper.CategoryAdapter;
import com.lgt.Adaper.ProductAdapter;
import com.lgt.Adaper.SliderAdapterExample;
import com.lgt.Model.SliderItem;
import com.lgt.rashanwala.DashboardActivity;
import com.lgt.rashanwala.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ShopHomeFragment extends Fragment {

    RecyclerView rv_services_we_provide, rv_latest_added_products;
    SliderAdapterExample adapter;
    BottomNavigationView bnv_bottomNavigation;
    CategoryAdapter categoryAdapter;
    SliderItem sliderItem;
    SliderView sliderView;
    ArrayList<Integer> mList = new ArrayList<>();
    ArrayList<String> mNameList = new ArrayList<>();
    ArrayList<String> productList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_home_fragment, container, false);
        // init
        sliderView = view.findViewById(R.id.imageSlider);
        bnv_bottomNavigation = view.findViewById(R.id.bnv_bottomNavigation);
        rv_services_we_provide = view.findViewById(R.id.rv_services_we_provide);
        rv_latest_added_products = view.findViewById(R.id.rv_latest_added_products);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        // adapter
        adapter = new SliderAdapterExample(getContext());
        sliderView.setSliderAdapter(adapter);
        // set adapter
        setAdapterData();
        rv_latest_added_products.setHasFixedSize(true);
        rv_services_we_provide.setHasFixedSize(true);
        rv_services_we_provide.setLayoutManager(new GridLayoutManager(getContext(), 5));
        rv_latest_added_products.setLayoutManager(layoutManager);
        setRecentProductAdapter();
        setCategoryAdapter();
        return view;
    }

    private void setRecentProductAdapter() {
        productList.add("Whole wheat bread");
        productList.add("Pita pockets");
        productList.add("English muffins");
        productList.add("Whole-grain");
        productList.add("Flour tortillas");
        productList.add("Ground turkey");
        ProductAdapter productAdapter = new ProductAdapter(getContext(), productList);
        rv_latest_added_products.setAdapter(productAdapter);
    }

    private void setCategoryAdapter() {
        // category icons
        mList.add(R.drawable.ic_add_product);
        mList.add(R.drawable.ic_category);
        mList.add(R.drawable.ic_order_setting);
        mList.add(R.drawable.ic_business_profile);
        mList.add(R.drawable.ic_order);
        mList.add(R.drawable.ic_enquiriey);
        mList.add(R.drawable.ic_rate_review);
        // category name
        mNameList.add("Add product");
        mNameList.add("Add category");
        mNameList.add("Order setting");
        mNameList.add("business profile");
        mNameList.add("Order");
        mNameList.add("Enquiry");
        mNameList.add("Rate review");
        categoryAdapter = new CategoryAdapter(getContext(), mList, mNameList);
        rv_services_we_provide.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }

    private void setAdapterData() {
        sliderItem = new SliderItem();
        sliderItem.setImageUrl("https://i.pinimg.com/originals/8a/7a/4a/8a7a4aef5321cbe2cb3a9c820caf7a9e.jpg");
        adapter.addItem(sliderItem);
        sliderView.setSliderAdapter(adapter);
        adapter.notifyDataSetChanged();
        // home screen slider
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}

package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lgt.Adaper.CategoryAdapter;
import com.lgt.Adaper.ProductAdapter;
import com.lgt.Adaper.SliderAdapterExample;
import com.lgt.Common.CommonCheck;
import com.lgt.Model.CategoryModel;
import com.lgt.Model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView rv_services_we_provide,rv_latest_added_products;
    SliderAdapterExample adapter;
    CategoryAdapter categoryAdapter;
    SliderItem sliderItem;
    SliderView sliderView;
    ArrayList<Integer> mList = new ArrayList<>();
    ArrayList<String> mNameList = new ArrayList<>();
    ArrayList<String> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // status bar color
        CommonCheck.changeStatusBarColor("#979898", this);
        // init
        sliderView = findViewById(R.id.imageSlider);
        rv_services_we_provide = findViewById(R.id.rv_services_we_provide);
        rv_latest_added_products = findViewById(R.id.rv_latest_added_products);
        // adapter
        adapter = new SliderAdapterExample(this);
        sliderView.setSliderAdapter(adapter);
        // set adapter
        setAdapterData();
        rv_latest_added_products.setHasFixedSize(true);
        rv_services_we_provide.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_services_we_provide.setLayoutManager(new GridLayoutManager(this, 5));
        rv_latest_added_products.setLayoutManager(layoutManager);
        setRecentProductAdapter();
        setCategoryAdapter();
    }

    private void setRecentProductAdapter() {
        productList.add("Whole wheat bread");
        productList.add("Pita pockets");
        productList.add("English muffins");
        productList.add("Whole-grain");
        productList.add("Flour tortillas");
        productList.add("Ground turkey");
        ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(),productList);
        rv_latest_added_products.setAdapter(productAdapter);
    }

    private void setCategoryAdapter() {
        // category icons
        mList.add(R.drawable.ic_add_product);
        mList.add(R.drawable.ic_category);
        mList.add(R.drawable.ic_order_setting);
        mList.add(R.drawable.ic_business_profile);
        mList.add(R.drawable.ic_add_staff);
        mList.add(R.drawable.ic_order);
        mList.add(R.drawable.ic_enquiriey);
        //mList.add(R.drawable.ic_gift_card);
        mList.add(R.drawable.ic_rate_review);
        // category name
        mNameList.add("Add product");
        mNameList.add("Add category");
        mNameList.add("Order setting");
        mNameList.add("business profile");
        mNameList.add("Add staff");
        mNameList.add("Order");
        mNameList.add("Enquiry");
        //mNameList.add("Gift card");
        mNameList.add("Rate review");
        categoryAdapter = new CategoryAdapter(this,mList,mNameList);
        rv_services_we_provide.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }

    private  void setAdapterData(){
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
package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.lgt.Adaper.CartAdapter;
import com.lgt.Adaper.ProductAdapter;
import com.lgt.Common.CommonCheck;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView rv_cart_list_items;
    ArrayList<String> productList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        // change status bar color
        CommonCheck.changeStatusBarColor("#6cb214", this);
        // init
        rv_cart_list_items = findViewById(R.id.rv_cart_list_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_cart_list_items.hasFixedSize();
        rv_cart_list_items.setLayoutManager(layoutManager);
        // set adapter
        setRecentProductAdapter();
    }

    private void setRecentProductAdapter() {
        productList.add("Whole wheat bread");
        productList.add("Flour tortillas");
        productList.add("Ground turkey");
        CartAdapter productAdapter = new CartAdapter(getApplicationContext(),productList);
        rv_cart_list_items.setAdapter(productAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(CartActivity.this,MainActivity.class));
        finishAffinity();
    }
}
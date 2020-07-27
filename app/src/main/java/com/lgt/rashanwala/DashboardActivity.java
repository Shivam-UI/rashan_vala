package com.lgt.rashanwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lgt.Adaper.CategoryAdapter;
import com.lgt.Adaper.ProductAdapter;
import com.lgt.Adaper.SliderAdapterExample;
import com.lgt.Common.CommonCheck;
import com.lgt.Fragment.HomeFragment;
import com.lgt.Fragment.OfferFragment;
import com.lgt.Fragment.ProfileFragment;
import com.lgt.Fragment.StoreFragment;
import com.lgt.Model.CategoryModel;
import com.lgt.Model.SliderItem;
import com.lgt.ShopFragment.ShopCategoryFragment;
import com.lgt.ShopFragment.ShopHomeFragment;
import com.lgt.ShopFragment.ShopProfileFragment;
import com.lgt.ShopFragment.shopOrderFragment;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bnv_bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // status bar color
        CommonCheck.changeStatusBarColor("#979898", this);
        // load Fragment
        loadFragment(new ShopHomeFragment());
        // init
        bnv_bottomNavigation = findViewById(R.id.bnv_bottomNavigation);
        // set bottom navigation
        setupBottomNavigation();
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_shop_frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void setupBottomNavigation() {
        bnv_bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bt_Home:
                        loadFragment(new ShopHomeFragment());
                        break;
                    case R.id.bt_category:
                        loadFragment(new ShopCategoryFragment());
                        break;
                    case R.id.bt_order:
                        loadFragment(new shopOrderFragment());
                        break;
                    case R.id.bt_profile:
                        loadFragment(new ShopProfileFragment());
                        break;
                    default:
                        loadFragment(new ShopHomeFragment());
                        break;
                }
                return true;
            }
        });
    }
}
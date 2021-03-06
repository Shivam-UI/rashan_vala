package com.lgt.rashanwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lgt.Common.CommonCheck;
import com.lgt.Fragment.HomeFragment;
import com.lgt.Fragment.OfferFragment;
import com.lgt.Fragment.ProfileFragment;
import com.lgt.Fragment.StoreFragment;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    ImageView iv_cart_list_view;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // change status bar color
        CommonCheck.changeStatusBarColor("#6cb214", this);
        // load Fragment
        loadFragment(new HomeFragment());
        // set navigation
        mBottomNavigationView = findViewById(R.id.bnv_bottomNavigation);
        iv_cart_list_view = findViewById(R.id.iv_cart_list_view);
        iv_cart_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
                finishAffinity();
            }
        });
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bt_Home:
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.bt_Store:
                        loadFragment(new StoreFragment());
                        break;
                    case R.id.bt_cart:
                        startActivity(new Intent(MainActivity.this, CartActivity.class));
                        finishAffinity();
                        break;
                    case R.id.bt_delivery:
                        loadFragment(new OfferFragment());
                        break;
                    case R.id.bt_profile:
                        loadFragment(new ProfileFragment());
                        break;
                    default:
                        loadFragment(new HomeFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_frame_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            //Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog.setTitle("Exit");
            sweetAlertDialog.setContentText("You Really Want To Exit");
            sweetAlertDialog.setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog.dismissWithAnimation();
                }
            });
            sweetAlertDialog.setConfirmButton("Conform", new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    finishAffinity();
                }
            });
            sweetAlertDialog.show();
        }
    }
}
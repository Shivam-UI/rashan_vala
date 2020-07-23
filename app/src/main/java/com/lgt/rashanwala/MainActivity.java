package com.lgt.rashanwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lgt.Common.CommonCheck;
import com.lgt.Fragment.HomeFragment;
import com.lgt.Fragment.StoreFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
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

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bt_Home :
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.bt_Store:
                        Toast.makeText(MainActivity.this, "Store", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bt_cart:
                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bt_delivery:
                        Toast.makeText(MainActivity.this, "Offers", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bt_profile:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
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
        fragmentTransaction.replace(R.id.fl_home_frame_container,fragment);
        fragmentTransaction.commit();
    }


}
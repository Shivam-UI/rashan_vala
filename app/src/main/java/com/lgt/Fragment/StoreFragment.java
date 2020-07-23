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
import com.lgt.Model.ProductModel;
import com.lgt.rashanwala.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StoreFragment extends Fragment {
    // setup menu
    private static ViewPager mPager, vp_middle_pager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.banner_4, R.drawable.banner_2, R.drawable.banner_3, R.drawable.banner_2};
    private static final Integer[] IMAGES_MIDDLE = {R.drawable.banner_4, R.drawable.banner_5, R.drawable.banner_6, R.drawable.banner_4};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ArrayList<Integer> ImagesMiddleArray = new ArrayList<Integer>();
    // recycler list
    RecyclerView rv_home_category,rv_category_one, rv_category_two, rv_category_three;
    HomeAdapter mHomeAdapter, mHomeAdapterTwo, mHomeAdapterThree;
    List<ProductModel> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.store_layout, container, false);
        // init view
        mPager = (ViewPager) view.findViewById(R.id.pager);
        vp_middle_pager = (ViewPager) view.findViewById(R.id.vp_middle_pager);
        rv_category_one = view.findViewById(R.id.rv_category_one);
        rv_category_two = view.findViewById(R.id.rv_category_two);
        rv_category_three = view.findViewById(R.id.rv_category_three);
        // set data
        init();
        // set category
        initCategory();
        // set layout manager
        initList();
        // init middle banner
        return view;
    }

    private void initCategory() {

    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager layoutManager_two = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager layoutManager_there = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rv_category_one.setLayoutManager(layoutManager);
        rv_category_two.setLayoutManager(layoutManager_two);
        rv_category_three.setLayoutManager(layoutManager_there);
        List<ProductModel> mlist_one = new ArrayList<>();
        List<ProductModel> mlist_two = new ArrayList<>();
        List<ProductModel> mlist_three = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductModel model_one = new ProductModel();
            ProductModel model_two = new ProductModel();
            ProductModel model_three = new ProductModel();
            model_one.image = R.drawable.product_1;
            mlist_one.add(model_one);
            model_two.image = R.drawable.grocry;
            mlist_two.add(model_two);
            model_three.image = R.drawable.kitchen;
            mlist_three.add(model_three);
        }
        // set adapter
        mHomeAdapter = new HomeAdapter(getActivity(), mlist_one);
        mHomeAdapterTwo = new HomeAdapter(getActivity(), mlist_two);
        mHomeAdapterThree = new HomeAdapter(getActivity(), mlist_three);
        // set adapter
        rv_category_one.setAdapter(mHomeAdapter);
        rv_category_two.setAdapter(mHomeAdapterTwo);
        rv_category_three.setAdapter(mHomeAdapterThree);
    }

    private void init() {
        for (int i = 0; i < IMAGES.length; i++) {
            ImagesArray.add(IMAGES[i]);
        }
        mPager.setAdapter(new SlidingImage_Adapter(getActivity().getApplicationContext(), ImagesArray));
        for (int j = 0; j < IMAGES_MIDDLE.length; j++) {
            ImagesMiddleArray.add(IMAGES_MIDDLE[j]);
        }
        vp_middle_pager.setAdapter(new SlidingImage_Adapter(getActivity().getApplicationContext(), ImagesMiddleArray));
        final float density = getResources().getDisplayMetrics().density;
        NUM_PAGES = IMAGES.length;
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
                vp_middle_pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 9000000, 15000);

        // Pager listener over indicator
    }
}

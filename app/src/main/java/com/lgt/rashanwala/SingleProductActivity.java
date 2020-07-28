package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lgt.Adaper.HomeAdapter;
import com.lgt.Adaper.ImageSliderAdapter;
import com.lgt.Adaper.ReviewAdapter;
import com.lgt.Interface.HomeSliderInterface;
import com.lgt.Model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class SingleProductActivity extends AppCompatActivity implements HomeSliderInterface {
    RecyclerView rv_user_review_list, rv_similar_product, rv_product_image_slider;
    LinearLayout ll_add_to_cart, ll_save_for_later;
    FrameLayout fl_back_button;
    ReviewAdapter reviewAdapter;
    ArrayList<String> mList;
    HomeAdapter mHomeAdapter;
    ImageView iv_add_count, iv_remove_count,iv_product_main_banner;
    TextView tv_counter_text;
    private static final Integer[] IMAGES = {R.drawable.ic_slider_product_1, R.drawable.ic_slider_product_2, R.drawable.ic_slider_product_3, R.drawable.ic_slider_product_4,R.drawable.category_6};
    ImageSliderAdapter imageSliderAdapter;
    int Count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);
        // fit to full screen
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        // init view
        ll_add_to_cart = findViewById(R.id.ll_add_to_cart);
        ll_save_for_later = findViewById(R.id.ll_save_for_later);
        rv_user_review_list = findViewById(R.id.rv_user_review_list);
        fl_back_button = findViewById(R.id.fl_back_button);
        rv_similar_product = findViewById(R.id.rv_similar_product);
        rv_product_image_slider = findViewById(R.id.rv_product_image_slider);
        iv_add_count = findViewById(R.id.iv_add_count);
        iv_product_main_banner = findViewById(R.id.iv_product_main_banner);
        iv_remove_count = findViewById(R.id.iv_remove_count);
        tv_counter_text = findViewById(R.id.tv_counter_text);
        // set layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutSimilarManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        LinearLayoutManager RvImageLayoutSimilarManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        rv_user_review_list.hasFixedSize();
        rv_similar_product.hasFixedSize();
        rv_product_image_slider.hasFixedSize();
        rv_user_review_list.setLayoutManager(layoutManager);
        rv_similar_product.setLayoutManager(layoutSimilarManager);
        rv_product_image_slider.setLayoutManager(RvImageLayoutSimilarManager);
        // define interface

        // set Image Slider
        setImageSlider();
        // set adapter
        setReviewAdapter();
        // recent product adapter
        setRecentProductAdapter();
        // cart count
        setCounterItems();
        // back btn press
        setBackToHome();
        // setup click
        setUpClickEvent();
    }

    private void setImageSlider() {
        imageSliderAdapter = new ImageSliderAdapter(getApplicationContext(),IMAGES,this);
        rv_product_image_slider.setAdapter(imageSliderAdapter);
        imageSliderAdapter.notifyDataSetChanged();
    }

    private void setUpClickEvent() {
        ll_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SingleProductActivity.this, "Item Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });

        ll_save_for_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SingleProductActivity.this, "Item Added For Later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setBackToHome() {
        fl_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingleProductActivity.this, MainActivity.class));
                finishAffinity();
            }
        });
    }

    private void setCounterItems() {
        iv_add_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Count == 1) {
                    Count++;
                    tv_counter_text.setText("" + Count);
                } else {
                    Count++;
                    tv_counter_text.setText("" + Count);
                }
            }
        });
        iv_remove_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Count > 1) {
                    Count--;
                    tv_counter_text.setText("" + Count);
                } else if (Count == 1) {
                    Toast.makeText(SingleProductActivity.this, "Need atlast one item.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setReviewAdapter() {
        mList = new ArrayList<>();
        mList.add("Fresh Vag");
        mList.add("Woow Super test");
        mList.add("Mom like this");
        mList.add("happy to here");
        mList.add("fresh products");
        mList.add("good delivery time");
        reviewAdapter = new ReviewAdapter(getApplicationContext(), mList);
        rv_user_review_list.setAdapter(reviewAdapter);
    }

    private void setRecentProductAdapter() {
        List<ProductModel> mlist_one = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductModel model_one = new ProductModel();
            model_one.image = R.drawable.category_2;
            mlist_one.add(model_one);
        }
        mHomeAdapter = new HomeAdapter(getApplicationContext(), mlist_one);
        rv_similar_product.setAdapter(mHomeAdapter);
    }

    @Override
    public void sliderImageFound(int imageID) {
        iv_product_main_banner.setImageResource(imageID);
    }
}
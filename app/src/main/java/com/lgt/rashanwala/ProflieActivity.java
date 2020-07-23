package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.lgt.Common.CommonCheck;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProflieActivity extends AppCompatActivity {
    FrameLayout civ_shopkeeper;
    CircleImageView civ_buyers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proflie);
        // set status bar color
        CommonCheck.changeStatusBarColor("#6cb214", this);
        // init view
        init();
    }

    private void init(){
        civ_buyers = findViewById(R.id.civ_buyers);
        civ_shopkeeper = findViewById(R.id.civ_shopkeeper);
        civ_buyers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buyers = new Intent(ProflieActivity.this,SignUpActivity.class);
                buyers.putExtra("KEY_SIGN","buyers");
                startActivity(buyers);
                finishAffinity();
            }
        });
        civ_shopkeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopkeeper = new Intent(ProflieActivity.this,SignUpActivity.class);
                shopkeeper.putExtra("KEY_SIGN","Shopkeeper");
                startActivity(shopkeeper);
                finishAffinity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
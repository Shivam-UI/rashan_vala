package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.lgt.Common.CommonCheck;

public class SignUpActivity extends AppCompatActivity {
    TextView tv_login;
    Intent intent;
    LinearLayout ll_store_name_container,ll_registration_new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // change status color
        CommonCheck.changeStatusBarColor("#eae9e6", this);
        // init view
        tv_login = findViewById(R.id.tv_login);
        ll_store_name_container = findViewById(R.id.ll_store_name_container);
        ll_registration_new_user = findViewById(R.id.ll_registration_new_user);
        intent = getIntent();
        String KEY_UP = intent.getStringExtra("KEY_SIGN");
        if (KEY_UP.equalsIgnoreCase("buyers")) {
            Toast.makeText(this, "buyers", Toast.LENGTH_SHORT).show();
            ll_store_name_container.setVisibility(View.GONE);
        } else if (KEY_UP.equalsIgnoreCase("Shopkeeper")) {
            Toast.makeText(this, "Shopkeeper", Toast.LENGTH_SHORT).show();
        }
        init();
    }

    private void init() {
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, SigninActivity.class));
                finishAffinity();
            }
        });
        ll_registration_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                finishAffinity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SignUpActivity.this, ProflieActivity.class));
        finishAffinity();
    }
}
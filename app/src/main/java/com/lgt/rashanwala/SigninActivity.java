package com.lgt.rashanwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lgt.Common.CommonCheck;

public class SigninActivity extends AppCompatActivity {
    TextView tv_registration,tv_forget_password;
    LinearLayout ll_user_sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // change status bar color
        CommonCheck.changeStatusBarColor("#eae9e6", this);
        //init view
        init();
    }

    private void init() {
        tv_registration = findViewById(R.id.tv_registration);
        tv_forget_password = findViewById(R.id.tv_forget_password);
        ll_user_sign_in = findViewById(R.id.ll_user_sign_in);
        tv_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registration = new Intent(SigninActivity.this,ProflieActivity.class);
                startActivity(registration);
                finishAffinity();
            }
        });
        tv_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SigninActivity.this, "Forget Password!", Toast.LENGTH_SHORT).show();
            }
        });
        ll_user_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this,DashboardActivity.class));
                finishAffinity();
            }
        });
    }
}
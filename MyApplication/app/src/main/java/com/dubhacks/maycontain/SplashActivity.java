package com.dubhacks.maycontain;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private LinearLayout linearLayout;
    private Button dashboardBtn;
    private AssetManager assetManager;
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();
        dashboardBtn = (Button) findViewById(R.id.dashboard);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, HomepageActivity.class));
            }
        });
    }

    public void onClick(View view) {
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(SplashActivity.this, HomepageActivity.class));
        }
        else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}


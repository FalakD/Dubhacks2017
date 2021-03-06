package com.dubhacks.maycontain;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity {

    private Button profile;
    private Typeface tf;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(HomepageActivity.this, HomepageActivity.class));
                    return true;
                case R.id.navigation_saved:
                    startActivity(new Intent(HomepageActivity.this, SavedActivity.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(HomepageActivity.this, SearchActivity.class));
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        profile = (Button) findViewById(R.id.myProfileBtn);
        tf = Typeface.createFromAsset(getAssets(), "Fonts/mainFont.ttf");
        profile.setTypeface(tf);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomepageActivity.this, ProfileActivity.class));
            }
        });
    }

}

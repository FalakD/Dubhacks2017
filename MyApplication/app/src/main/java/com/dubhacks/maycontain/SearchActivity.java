package com.dubhacks.maycontain;

import android.graphics.Typeface;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    private Button searchBtn;
    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        searchBtn = (Button) findViewById(R.id.searchButton);
        tf = Typeface.createFromAsset(getAssets(), "Fonts/mainFont.ttf");
        searchBtn.setTypeface(tf);

    }
}

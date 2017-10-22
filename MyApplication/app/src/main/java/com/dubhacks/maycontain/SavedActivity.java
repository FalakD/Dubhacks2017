package com.dubhacks.maycontain;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity implements createPlaceDialog.Communicator, EditPlaceDialog.itemEditor {
    private Button addPlaceBtn;
    private createPlaceDialog dialog;
    private List<String> places;
    private PlaceAdapter adapter;
    private ListView list;
    private Typeface tf;
    private TextView savedTitle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(SavedActivity.this, HomepageActivity.class));
                    return true;
                case R.id.navigation_saved:
                    startActivity(new Intent(SavedActivity.this, SavedActivity.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(SavedActivity.this, SearchActivity.class));
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        savedTitle = (TextView) findViewById(R.id.titleSavedPage);
        tf = Typeface.createFromAsset(getAssets(), "Fonts/mainFont.ttf");

        places = new ArrayList<>();
        places.add("Olive Garden");
        places.add("Cheesecake Factory");
        places.add("In n Out");
        list = (ListView) findViewById(R.id.listSavedRestaurants);
        adapter = new PlaceAdapter(places, SavedActivity.this);
        list.setAdapter(adapter);
        addPlaceBtn = (Button) findViewById(R.id.addPlace);
        addPlaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentManager manager = getFragmentManager();
                dialog = new createPlaceDialog();
                dialog.show(manager, "CreatePlace");
            }
        });

        list.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public void addCategory(String newTitle) throws IOException {
        places.add(newTitle);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void changeItem(int pos, String newName) {
        places.set(pos, newName);
        adapter.notifyDataSetChanged();
    }
}

package com.dubhacks.maycontain;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity implements createPlaceDialog.Communicator, EditPlaceDialog.itemEditor {
    private Button addPlaceBtn;
    private createPlaceDialog dialog;
    private List<String> places;
    private PlaceAdapter adapter;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

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

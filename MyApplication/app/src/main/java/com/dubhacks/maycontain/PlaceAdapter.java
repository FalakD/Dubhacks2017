package com.dubhacks.maycontain;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Falak on 10/22/17.
 */

public class PlaceAdapter extends BaseAdapter implements ListAdapter {
    private List categories = new ArrayList();
    private View v;
    private Context context;
    private int position;
    private DeleteWarningDialog dialog;
    private EditPlaceDialog dialogEdit;
    private FragmentActivity activity;
    private FragmentManager manager;
    private Typeface tf;

    public PlaceAdapter(List list, Context c){
        categories = list;
        context = c;
        activity = (FragmentActivity) context;
        manager = activity.getFragmentManager();
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0; //user created list has no item ID
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        v = view;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_layout, null);
        }

        final TextView listItem = (TextView) v.findViewById(R.id.list_item_string);
        listItem.setText(categories.get(i).toString());
        tf = Typeface.createFromAsset(context.getAssets(), "Fonts/mainFont.ttf");
        listItem.setTypeface(tf);

        ImageButton editName = (ImageButton) v.findViewById(R.id.edit_btn);
        ImageButton deleteCat = (ImageButton) v.findViewById(R.id.delete_btn);

        deleteCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new DeleteWarningDialog();
                dialog.position = i;
                dialog.show(manager, "DeleteDialog");

            }
        });

        editName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dialogEdit = new EditPlaceDialog();
                dialogEdit.currentName = categories.get(i).toString();
                dialogEdit.pos = i;
                dialogEdit.show(manager, "EditDialog");
            }

        });

        listItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(activity, CategoryMainActivity.class);
                intent.putExtra("Category title", categories.get(i).toString());
                activity.startActivity(intent);
                */

            }
        });

        return v;
    }

}

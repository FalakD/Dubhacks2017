package com.dubhacks.maycontain;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Falak on 10/22/17.
 */

public class EditPlaceDialog extends DialogFragment implements View.OnClickListener {
    private Button ok;
    private EditText edit;
    String currentName;
    int pos;
    String newName;
    private itemEditor editor;
    private Typeface tf, tfBold;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        editor = (EditPlaceDialog.itemEditor) activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_edit_place, null);

        ok = (Button) view.findViewById(R.id.ok_btn);
        ok.setTypeface(tfBold);
        edit = (EditText) view.findViewById(R.id.editCat);
        edit.setTypeface(tfBold);
        edit.setTextSize(25);
        ok.setOnClickListener(this);

        edit.setText(currentName);

        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        newName = edit.getText().toString();
        editor.changeItem(pos, newName);
        dismiss();
    }

    public interface itemEditor {
        public void changeItem(int pos, String newName);
    }
}

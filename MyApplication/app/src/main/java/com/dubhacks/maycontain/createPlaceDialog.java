package com.dubhacks.maycontain;

/**
 * Created by Falak on 10/22/17.
 */

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class createPlaceDialog extends DialogFragment implements View.OnClickListener{
    private Button cancel, setNew;
    private EditText edit;
    private Communicator communicator;
    private Typeface tf;

    public void onAttach(Activity activity){
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_create_place_dialog, null);

        setCancelable(false);
        return view;
    }

    public void onClick(View view){
        if(view.getId()==R.id.cancelButton){
            dismiss();

        }
        else {
            String title = edit.getText().toString();
            try {
                communicator.addCategory(title);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dismiss();

        }
    }

    interface Communicator{
        void addCategory(String newTitle) throws IOException;
    }
}

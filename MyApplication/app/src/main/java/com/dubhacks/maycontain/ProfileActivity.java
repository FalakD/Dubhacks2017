package com.dubhacks.maycontain;

import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView name, allergies, t1, t2;
    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tf = Typeface.createFromAsset(getAssets(), "Fonts/mainFont.ttf");
        name = (TextView) findViewById(R.id.name);
        allergies = (TextView) findViewById(R.id.allergies);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);

        name.setTypeface(tf);
        allergies.setTypeface(tf);
        t1.setTypeface(tf);
        t2.setTypeface(tf);


    }
}

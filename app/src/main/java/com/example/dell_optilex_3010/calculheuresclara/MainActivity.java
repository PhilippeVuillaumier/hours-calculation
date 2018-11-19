package com.example.dell_optilex_3010.calculheuresclara;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText eT1, eT2, eT3, eT4, eT5, eT6, eT7, eT8, eT9;
    private TextView tV4, tV5, tV6, tV7, tV8, tV9, tV10, tV11, tV12;
    private Button bT1, bT2, bT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
        eT4 = findViewById(R.id.eT4);
        eT5 = findViewById(R.id.eT5);
        eT6 = findViewById(R.id.eT6);
        eT7 = findViewById(R.id.eT7);
        eT8 = findViewById(R.id.eT8);
        eT9 = findViewById(R.id.eT9);

    }

    public void Plus(View view) {

        int s1 = Integer.parseInt(eT3.getText().toString());
        int s2 = Integer.parseInt(eT6.getText().toString());
        int testSec = Test(s1, s2);
        int s3 = s1 + s2 - testSec * 60;
        eT9.setText(String.valueOf(s3));
        int m1 = Integer.parseInt(eT2.getText().toString()) + testSec;
        int m2 = Integer.parseInt(eT5.getText().toString());
        int testMin = Test(m1, m2);
        int m3 = m1 + m2 - testMin * 60;
        eT8.setText(String.valueOf(m3));
        int h1 = Integer.parseInt(eT1.getText().toString()) + testMin;
        int h2 = Integer.parseInt(eT4.getText().toString());
        int h3 = h1 + h2;
        eT7.setText(String.valueOf(h3));

        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void Moins(View view) {
        int s1 = Integer.parseInt(eT3.getText().toString()) +
                (Integer.parseInt(eT2.getText().toString())) * 60 +
                (Integer.parseInt(eT1.getText().toString())) * 3600;
        int s2 = Integer.parseInt(eT6.getText().toString()) +
                (Integer.parseInt(eT5.getText().toString())) * 60 +
                (Integer.parseInt(eT4.getText().toString())) * 3600;
        int s3 = s1 - s2;
        int totheur = s3 / 3600;
        int m3 = s3 - totheur * 3600;
        int totmin = m3 / 60;
        int totsec = m3 % 60;
        eT9.setText(String.valueOf(totsec));
        eT8.setText(String.valueOf(totmin));
        eT7.setText(String.valueOf(totheur));

        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public int Test(int i, int j) {
        return (i + j) / 60;
    }

    public void Clear(View view) {
        eT1.setText("0");
        eT2.setText("0");
        eT3.setText("0");
        eT4.setText("0");
        eT5.setText("0");
        eT6.setText("0");
        eT7.setText("0");
        eT8.setText("0");
        eT9.setText("0");

    }
}


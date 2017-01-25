package com.sooperbala.apr_agency;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MilkAdder extends AppCompatActivity {

    TextView tvStoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_adder);

        tvStoreName = (TextView) findViewById(R.id.textView3);


        Intent i = getIntent();
        String sltStore = i.getStringExtra("sltKadai");

        tvStoreName.setText(sltStore);
    }
}

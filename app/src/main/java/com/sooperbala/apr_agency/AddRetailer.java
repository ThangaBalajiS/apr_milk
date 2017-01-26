package com.sooperbala.apr_agency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddRetailer extends AppCompatActivity {

    EditText etAddret;
    CountSupport cd = new CountSupport();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_retailer);

        etAddret = (EditText) findViewById(R.id.etAddRetailer);
        cd.run();
    }


    public void adder(View view) {
        cd.stores.add(etAddret.getText().toString());

    }
}

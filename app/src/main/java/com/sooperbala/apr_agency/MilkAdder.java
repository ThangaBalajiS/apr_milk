package com.sooperbala.apr_agency;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MilkAdder extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvStoreName;
    Spinner spHeri, spSang, spDod, spRed, spGreen, spBlue, spSmall, sp200ml, sp500ml;
    CountSupport cd = new CountSupport();
    String sltStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_adder);
        cd.run();
        tvStoreName = (TextView) findViewById(R.id.shopName);
        spHeri = (Spinner) findViewById(R.id.spHeri);
        spSang = (Spinner) findViewById(R.id.spSang);
        spDod = (Spinner) findViewById(R.id.spDod);
        spRed = (Spinner) findViewById(R.id.spRed);
        spGreen = (Spinner) findViewById(R.id.spGreen);
        spBlue = (Spinner) findViewById(R.id.spBlue);
        spSmall = (Spinner) findViewById(R.id.spSmall);
        sp200ml = (Spinner) findViewById(R.id.sp200ML);
        sp500ml = (Spinner) findViewById(R.id.sp500ML);


        ArrayAdapter ap = new ArrayAdapter(this, R.layout.spinnertxt, cd.milkCount);


        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spHeri.setAdapter(ap);
        spSang.setAdapter(ap);
        spDod.setAdapter(ap);
        spRed.setAdapter(ap);
        spGreen.setAdapter(ap);
        spBlue.setAdapter(ap);
        spSmall.setAdapter(ap);
        sp200ml.setAdapter(ap);
        sp500ml.setAdapter(ap);

        Intent i = getIntent();
        sltStore = i.getStringExtra("sltKadai");

        tvStoreName.setText(sltStore);

        spHeri.setOnItemSelectedListener(this);
        spSang.setOnItemSelectedListener(this);
        spDod.setOnItemSelectedListener(this);
        spRed.setOnItemSelectedListener(this);
        spGreen.setOnItemSelectedListener(this);
        spBlue.setOnItemSelectedListener(this);
        spSmall.setOnItemSelectedListener(this);
        sp200ml.setOnItemSelectedListener(this);
        sp500ml.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String gg = spDod.getSelectedItem().toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        final ProgressDialog dialog = ProgressDialog.show(MilkAdder.this, "",
                "Uploading Plz Wait...", true);
        dialog.setIndeterminate(true);
        dialog.show();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        String formattedDate = df.format(c.getTime());

        ParseObject paalKanakku = new ParseObject("kanakku");
        paalKanakku.put("date", formattedDate);
        paalKanakku.put("kadai", sltStore);
        paalKanakku.put("heri", spHeri.getSelectedItem().toString());
        paalKanakku.put("sang", spSang.getSelectedItem().toString());
        paalKanakku.put("dod", spDod.getSelectedItem().toString());
        paalKanakku.put("red", spRed.getSelectedItem().toString());
        paalKanakku.put("green", spGreen.getSelectedItem().toString());
        paalKanakku.put("blue", spBlue.getSelectedItem().toString());
        paalKanakku.put("small", spSmall.getSelectedItem().toString());
        paalKanakku.put("ml2", sp200ml.getSelectedItem().toString());
        paalKanakku.put("ml5", sp500ml.getSelectedItem().toString());
        paalKanakku.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {

                    Toast.makeText(getApplicationContext(), "Posted Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                } else {

                    Toast.makeText(getApplicationContext(), e.getMessage() + "Try Again", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        return super.onOptionsItemSelected(item);
    }
}

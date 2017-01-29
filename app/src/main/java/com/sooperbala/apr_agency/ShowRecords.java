package com.sooperbala.apr_agency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ShowRecords extends AppCompatActivity {

    TextView tvHeri, tvSang, tvDod, tvRed, tvGreen, tvBlue, tvSmall, tv200ml, tv500ml;
    Intent i;
    String sltKadai, sltDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

        tvHeri = (TextView) findViewById(R.id.heriC);
        tvSang = (TextView) findViewById(R.id.sangC);
        tvDod = (TextView) findViewById(R.id.dodC);
        tvRed = (TextView) findViewById(R.id.redC);
        tvGreen = (TextView) findViewById(R.id.greenC);
        tvBlue = (TextView) findViewById(R.id.bluC);
        tvSmall = (TextView) findViewById(R.id.smallC);
        tv200ml = (TextView) findViewById(R.id.ml2C);
        tv500ml = (TextView) findViewById(R.id.ml5C);

        i = getIntent();
        sltKadai = i.getStringExtra("sltKadai");
        sltDate = i.getStringExtra("sltDate");


        ParseQuery<ParseObject> milkData = ParseQuery.getQuery("kanakku");
        milkData.whereEqualTo("date", sltDate);

        milkData.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0) {

                    for (ParseObject s : objects) {

                        tvHeri.setText(s.getString("heri"));
                        tvSang.setText(s.getString("sang"));
                        tvDod.setText(s.getString("dod"));
                        tvRed.setText(s.getString("red"));
                        tvGreen.setText(s.getString("green"));
                        tvBlue.setText(s.getString("blue"));
                        tvSmall.setText(s.getString("small"));
                        tv200ml.setText(s.getString("ml2"));
                        tv500ml.setText(s.getString("ml5"));

                    }

                }

            }
        });

    }


}

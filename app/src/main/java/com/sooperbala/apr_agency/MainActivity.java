package com.sooperbala.apr_agency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.parse.Parse;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseInite();
        CountSupport cd = new CountSupport();
        cd.run();
    }

    public void parseInite(){
        //method to initialize the parse server
        try {

            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("sfjdkljslfjlsjflsdjflj")
                    .server("http://aprdsjhfdsjf.herokuapp.com/parse/")
                    .build()
            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void viewData(View view) {

        Intent i = new Intent(this, GetRecords.class);
        startActivity(i);

    }

}


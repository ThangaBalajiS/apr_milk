package com.sooperbala.apr_agency;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.parse.Parse;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    String dateeTym;
    TextView tvDate;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseInite();

        tvDate = (TextView) findViewById(R.id.textView);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);



    }

    public void setDate(View view) {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day

            dateeTym = new StringBuilder().append(arg3).append("/")
                    .append(arg2 + 1).append("/").append(arg1).toString();
            tvDate.setText(dateeTym);

            Intent i = new Intent(getApplicationContext(), DayEntry.class);
            startActivity(i);
        }
    };


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
}

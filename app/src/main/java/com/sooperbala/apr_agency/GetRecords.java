package com.sooperbala.apr_agency;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Calendar;

public class GetRecords extends AppCompatActivity {


    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    String dateeTym;
    EditText etSearch;
    CountSupport cs;
    ListView lv;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_records);



        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        showDialog(999);


        etSearch = (EditText) findViewById(R.id.editText);

        cs = new CountSupport();
        cs.run();
        ad = new ArrayAdapter(this, R.layout.listt, cs.stores);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(ad);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                GetRecords.this.ad.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), ShowRecords.class);
                intent.putExtra("sltKadai", (String) ad.getItem(i));
                intent.putExtra("sltDate", dateeTym);
                startActivity(intent);

            }
        });

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

            String argg = "0";
            if (arg2 + 1 < 10) {
                argg = "0" + String.valueOf(arg2 + 1);
            }

            dateeTym = new StringBuilder().append(arg3)
                    .append(argg).append(arg1).toString();

        }
    };
}

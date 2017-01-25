package com.sooperbala.apr_agency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class DayEntry extends AppCompatActivity {

    EditText etSearch;
    CountSupport cs;
    ListView lv;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_entry);

        etSearch = (EditText) findViewById(R.id.editText);

        cs = new CountSupport();
        cs.initShopList();
        ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cs.stores);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(ad);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                DayEntry.this.ad.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), MilkAdder.class);
                intent.putExtra("sltKadai", (String) ad.getItem(i));
                startActivity(intent);

            }
        });
    }


}

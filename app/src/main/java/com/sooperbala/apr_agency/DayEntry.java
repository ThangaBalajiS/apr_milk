package com.sooperbala.apr_agency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class DayEntry extends AppCompatActivity {

    EditText etSearch;
    CountSupport cs;
    TextView tvSearchResult;
    String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_entry);

        etSearch = (EditText) findViewById(R.id.editText);
        tvSearchResult = (TextView) findViewById(R.id.textView2);
        cs = new CountSupport();
        cs.initShopList();

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                for(String s : cs.stores){
                    if(s.contains(etSearch.getText().toString())){

                        f = f + s;
                        tvSearchResult.setText(f);

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}

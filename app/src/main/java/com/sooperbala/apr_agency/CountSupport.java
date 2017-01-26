package com.sooperbala.apr_agency;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by bala on 22-01-2017.
 */

public class CountSupport extends Application implements Runnable {

    ArrayList<String> stores = new ArrayList();
    ArrayList<Integer> milkCount = new ArrayList();
    ArrayAdapter milkAdap;

    @Override
    public void run() {


        //lines to add values to stores arraylist
        stores.add("THATHA KADA");
        stores.add("KANNADI MACHAN");
        stores.add("KANAGAVEL");
        stores.add("RASION KADA");
        stores.add("MEENA STORE");
        stores.add("DURAI RAJ");
        stores.add("AYYAPPAN");
        stores.add("TATA KADA");
        stores.add("THENDRAL KADA");
        stores.add("PUTHU KADA");
        stores.add("BAI AMMA");
        stores.add("YERI KADA");
        stores.add("SAMSA KADA");
        stores.add("SAMVEL KADA");
        stores.add("KULLAN KADA");
        stores.add("SELVA SINGH");
        stores.add("DEVI AKKA");
        stores.add("BABY AKKA");
        stores.add("MUTHU TEA KADA");
        stores.add("KUMAR TEA KADA");
        stores.add("KARUPPAN KADA");
        stores.add("MADASWAMY");
        stores.add("VICKY KADA");
        stores.add("MAHARAJA");
        stores.add("ARUNACHALAM");
        stores.add("KEEPER KADA");
        stores.add("ICE KADA");
        stores.add("BAI KADA");
        stores.add("SADU KADA");
        stores.add("TEA KADA");
        stores.add("PAPER KADA");
        stores.add("CANTEEN");
        stores.add("BAI KADA");
        stores.add("MADHA KADA");
        stores.add("RAM TEA KADA");
        stores.add("PSYCHO KADA");
        stores.add("ADITHAN");
        stores.add("SARATHI KADA");
        stores.add("K.K.NAGAR KADA");
        stores.add("KARI KADA");
        stores.add("YALANI KADA");
        stores.add("MUTU TEA KADA");
        stores.add("KANNADI KADA");
        stores.add("DEVA TEA KADA");
        stores.add("RAJI KADA");
        stores.add("MUTHUKANNI");
        stores.add("SEDU");
        stores.add("SOYAMBU");
        stores.add("SELVA RAJ");
        stores.add("KALI MUTHU");
        stores.add("PAPER ");
        stores.add("AKKA");
        stores.add("KOVIL TEA KADA");
        stores.add("THAI TEA STAL");
        stores.add("JUICE KADA");
        stores.add("LAKSHIMIPURAM");
        stores.add("JERSEY");
        stores.add("ATTANTHANGAL");
        stores.add("RASNA");
        stores.add("PALANICHAMY");
        stores.add("PAMATHUKULAM");
        stores.add("PERUMALADIPADHAM");
        stores.add("MICHEL");


        //add numbers for drop down
        for (int fi = 0; fi < 50; fi++) {

            milkCount.add(fi);

        }

        milkAdap = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, milkCount);

    }
}

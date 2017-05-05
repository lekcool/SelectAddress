package com.lek.cool.selectaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.lek.cool.addresslibrary.AddressManager;
import com.lek.cool.addresslibrary.OnItemAddressSelectListener;
import com.lek.cool.addresslibrary.model.District;
import com.lek.cool.addresslibrary.model.Province;
import com.lek.cool.addresslibrary.model.SubDistrict;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AddressManager addressManager;

    private Spinner snProvince;
    private Spinner snDistrict;
    private Spinner snSubDistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        snProvince = (Spinner) findViewById(R.id.snProvince);
        snDistrict = (Spinner) findViewById(R.id.snDistrict);
        snSubDistrict = (Spinner) findViewById(R.id.snSubDistrict);

        addressManager = new AddressManager(this, snProvince, snDistrict, snSubDistrict, new OnItemAddressSelectListener() {
            @Override
            public void onProvinceSelect(Province province) {

            }

            @Override
            public void onDistrictSelect(District district) {

            }

            @Override
            public void onSubDistrictSelect(SubDistrict subDistrict) {

            }
        });
    }
}

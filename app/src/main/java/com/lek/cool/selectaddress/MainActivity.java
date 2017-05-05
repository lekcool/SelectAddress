package com.lek.cool.selectaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.lek.cool.addresslibrary.AddressManager;
import com.lek.cool.addresslibrary.OnItemAddressSelectListener;
import com.lek.cool.addresslibrary.model.District;
import com.lek.cool.addresslibrary.model.Province;
import com.lek.cool.addresslibrary.model.SubDistrict;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemAddressSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        Spinner snProvince = (Spinner) findViewById(R.id.snProvince);
        Spinner snDistrict = (Spinner) findViewById(R.id.snDistrict);
        Spinner snSubDistrict = (Spinner) findViewById(R.id.snSubDistrict);

        new AddressManager(this, snProvince, snDistrict, snSubDistrict, this);
    }

    @Override
    public void onProvinceSelect(Province province) {

    }

    @Override
    public void onDistrictSelect(District district) {

    }

    @Override
    public void onSubDistrictSelect(SubDistrict subDistrict) {

    }
}

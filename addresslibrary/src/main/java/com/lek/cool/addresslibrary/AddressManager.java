package com.lek.cool.addresslibrary;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lek.cool.addresslibrary.model.District;
import com.lek.cool.addresslibrary.model.Province;
import com.lek.cool.addresslibrary.model.SubDistrict;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {

    private List<District> districts;
    private List<SubDistrict> subDistricts;

    public AddressManager(final Context context, final Spinner snProvince, final Spinner snDistrict, final Spinner snSubDistrict, final OnItemAddressSelectListener listener) {
        final List<Province> provincesAll = new Gson().fromJson(readFromFile("changwats.json", context), new TypeToken<List<Province>>(){}.getType());
        final List<District> districtsAll = new Gson().fromJson(readFromFile("amphoes.json", context), new TypeToken<List<District>>(){}.getType());
        final List<SubDistrict> subDistrictsAll = new Gson().fromJson(readFromFile("tambons.json", context), new TypeToken<List<SubDistrict>>(){}.getType());

        districts = districtsAll;
        subDistricts = subDistrictsAll;

        List<String> pList = new ArrayList<>();
        for (Province province : provincesAll) {
            pList.add(province.getName());
        }

        setupSpinnerAdapter(context, pList, snProvince);

        snProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Province province = provincesAll.get(position);
                List<String> districtList = new ArrayList<>();
                districts = new ArrayList<>();
                for (District district : districts) {
                    if (district.getProvinceId().equals(province.getId())) {
                        districts.add(district);
                        districtList.add(district.getName());
                    }
                }

                setupSpinnerAdapter(context, districtList, snDistrict);

                if (listener != null) {
                    listener.onProvinceSelect(province);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        snDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                District district = districts.get(position);
                List<String> subDistrictList = new ArrayList<>();
                subDistricts = new ArrayList<>();
                for (SubDistrict subDistrict : subDistricts) {
                    if (subDistrict.getProvinceId().equals(district.getProvinceId()) && subDistrict.getDistroctId().equals(district.getId())) {
                        subDistricts.add(subDistrict);
                        subDistrictList.add(subDistrict.getName());
                    }
                }

                setupSpinnerAdapter(context, subDistrictList, snSubDistrict);

                if (listener != null) {
                    listener.onDistrictSelect(district);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        snSubDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SubDistrict subDistrict = subDistricts.get(position);
                if (listener != null) {
                    listener.onSubDistrictSelect(subDistrict);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupSpinnerAdapter(Context context, List<String> list, Spinner spinner) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line, list);
        spinner.setAdapter(adapter);
    }

    private String readFromFile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getAssets().open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}

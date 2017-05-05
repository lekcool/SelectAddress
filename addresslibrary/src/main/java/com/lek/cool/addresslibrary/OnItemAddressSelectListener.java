package com.lek.cool.addresslibrary;

import com.lek.cool.addresslibrary.model.District;
import com.lek.cool.addresslibrary.model.Province;
import com.lek.cool.addresslibrary.model.SubDistrict;

import java.util.List;

/**
 * Created by Cool on 5/5/2560.
 */

public interface OnItemAddressSelectListener {

    void onProvinceSelect(Province province);

    void onDistrictSelect(District district);

    void onSubDistrictSelect(SubDistrict subDistrict);
}

package com.lek.cool.addresslibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cool on 5/5/2560.
 */

public class District {

    @SerializedName("pid")
    private String id;

    @SerializedName("changwat_pid")
    private String provinceId;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

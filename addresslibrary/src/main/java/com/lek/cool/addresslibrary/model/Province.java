package com.lek.cool.addresslibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cool on 5/5/2560.
 */

public class Province {

    @SerializedName("pid")
    private String id;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

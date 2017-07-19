package com.example.x.bunuscustomer.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 01.07.2017.
 */
public class CategoryId {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("company_category")
    @Expose
    private String companyCategory;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
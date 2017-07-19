package com.example.x.bunuscustomer.retrofit.userInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 02.07.2017.
 */

public class AllUserInfo {

    @SerializedName("userinfo")
    @Expose
    private UInfo userinfo;
    @SerializedName("company_user")
    @Expose
    private CInfo companyUser;

    public UInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UInfo userinfo) {
        this.userinfo = userinfo;
    }

    public CInfo getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CInfo companyUser) {
        this.companyUser = companyUser;
    }

}

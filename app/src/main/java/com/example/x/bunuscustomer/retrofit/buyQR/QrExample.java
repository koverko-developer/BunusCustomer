package com.example.x.bunuscustomer.retrofit.buyQR;

import com.example.x.bunuscustomer.retrofit.buyQR.CompanyUser;
import com.example.x.bunuscustomer.retrofit.buyQR.LoyaltyStep;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 04.07.2017.
 */

public class QrExample {
    @SerializedName("userinfo")
    @Expose
    private Userinfo userinfo;
    @SerializedName("company_user")
    @Expose
    private CompanyUser companyUser;
    @SerializedName("sale")
    @Expose
    private String sale;
    @SerializedName("loyalty")
    @Expose
    private String loyalty;
    @SerializedName("loyalty_step")
    @Expose
    private LoyaltyStep loyaltyStep;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public LoyaltyStep getLoyaltyStep() {
        return loyaltyStep;
    }

    public void setLoyaltyStep(LoyaltyStep loyaltyStep) {
        this.loyaltyStep = loyaltyStep;
    }

}

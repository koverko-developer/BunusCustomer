package com.example.x.bunuscustomer.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 01.07.2017.
 */

public class CompanyUser {
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("col_buy")
    @Expose
    private String colBuy;
    @SerializedName("col_bal")
    @Expose
    private String colBal;
    @SerializedName("status_company_user")
    @Expose
    private String statusCompanyUser;



    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getColBuy() {
        return colBuy;
    }

    public void setColBuy(String colBuy) {
        this.colBuy = colBuy;
    }

    public String getColBal() {
        return colBal;
    }

    public void setColBal(String colBal) {
        this.colBal = colBal;
    }

    public String getStatusCompanyUser() {
        return statusCompanyUser;
    }

    public void setStatusCompanyUser(String statusCompanyUser) {
        this.statusCompanyUser = statusCompanyUser;
    }


}

package com.example.x.bunuscustomer.retrofit.buyQR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 04.07.2017.
 */

public class QrUserinfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fio")
    @Expose
    private String fio;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("last_buying")
    @Expose
    private String lastBuying;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastBuying() {
        return lastBuying;
    }

    public void setLastBuying(String lastBuying) {
        this.lastBuying = lastBuying;
    }
}

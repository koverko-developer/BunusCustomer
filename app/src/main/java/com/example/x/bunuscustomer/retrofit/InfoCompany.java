package com.example.x.bunuscustomer.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 01.07.2017.
 */

public class InfoCompany {
    @SerializedName("mycompany")
    @Expose
    private Mycompany mycompany;

    public Mycompany getMycompany() {
        return mycompany;
    }

    public void setMycompany(Mycompany mycompany) {
        this.mycompany = mycompany;
    }

}

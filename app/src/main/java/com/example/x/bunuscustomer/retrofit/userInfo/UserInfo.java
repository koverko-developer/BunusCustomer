package com.example.x.bunuscustomer.retrofit.userInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 02.07.2017.
 */

public class UserInfo {

    @SerializedName("mycompany")
    @Expose
    private AllUserInfo mycompany;

    public AllUserInfo getMycompany() {
        return mycompany;
    }

    public void setMycompany(AllUserInfo mycompany) {
        this.mycompany = mycompany;
    }
}

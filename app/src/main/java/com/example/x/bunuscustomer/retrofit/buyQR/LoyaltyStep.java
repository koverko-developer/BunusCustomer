package com.example.x.bunuscustomer.retrofit.buyQR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 04.07.2017.
 */

public class LoyaltyStep {
    @SerializedName("step1")
    @Expose
    private String step1;
    @SerializedName("step2")
    @Expose
    private String step2;
    @SerializedName("step3")
    @Expose
    private String step3;
    @SerializedName("step4")
    @Expose
    private String step4;
    @SerializedName("step1_col")
    @Expose
    private String step1Col;
    @SerializedName("step2_col")
    @Expose
    private String step2Col;
    @SerializedName("step3_col")
    @Expose
    private String step3Col;
    @SerializedName("step4_col")
    @Expose
    private String step4Col;

    public String getStep1() {
        return step1;
    }

    public void setStep1(String step1) {
        this.step1 = step1;
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2;
    }

    public String getStep3() {
        return step3;
    }

    public void setStep3(String step3) {
        this.step3 = step3;
    }

    public String getStep4() {
        return step4;
    }

    public void setStep4(String step4) {
        this.step4 = step4;
    }

    public String getStep1Col() {
        return step1Col;
    }

    public void setStep1Col(String step1Col) {
        this.step1Col = step1Col;
    }

    public String getStep2Col() {
        return step2Col;
    }

    public void setStep2Col(String step2Col) {
        this.step2Col = step2Col;
    }

    public String getStep3Col() {
        return step3Col;
    }

    public void setStep3Col(String step3Col) {
        this.step3Col = step3Col;
    }

    public String getStep4Col() {
        return step4Col;
    }

    public void setStep4Col(String step4Col) {
        this.step4Col = step4Col;
    }

}

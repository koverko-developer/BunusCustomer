package com.example.x.bunuscustomer.fragments.classes;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Base64;

/**
 * Created by mobi app on 02.07.2017.
 */

public class UserInfoObject extends BaseObservable {

    private ObservableField<String> fio;
    private ObservableField<String> buyDate;
    private ObservableField<String> colFriend;
    private ObservableField<String> colBuy;
    private ObservableField<String> colBalls;
    private ObservableField<String> email;
    private ObservableField<String> phone;
    private ObservableBoolean progress;
    private ObservableField<String> sumBuy;

    public UserInfoObject(){
        fio = new ObservableField<>();
        buyDate = new ObservableField<>();
        colFriend = new ObservableField<>();
        colBuy = new ObservableField<>();
        colBalls = new ObservableField<>();
        email = new ObservableField<>();
        phone = new ObservableField<>();
        progress = new ObservableBoolean(false);
        sumBuy = new ObservableField<>();
    }

    public ObservableField<String> getFio() {
        return fio;
    }

    public void setFio(ObservableField<String> pfio) {
        fio.set(pfio.get());
    }

    public ObservableField<String> getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(ObservableField<String> pbuyDate) {
        buyDate.set(pbuyDate.get());
    }

    public ObservableField<String> getColFriend() {
        return colFriend;
    }

    public void setColFriend(ObservableField<String> pcolFriend) {
        colFriend.set(pcolFriend.get());
    }

    public ObservableField<String> getColBuy() {
        return colBuy;
    }

    public void setColBuy(ObservableField<String> pcolBuy) {
        colBuy.set(pcolBuy.get());
    }

    public ObservableField<String> getColBalls() {
        return colBalls;
    }

    public void setColBalls(ObservableField<String> pcolBalls) {
        colBalls.set(pcolBalls.get());
    }

    public ObservableField<String> getEmail() {
        return email;
    }

    public void setEmail(ObservableField<String> pemail) {
        email.set(pemail.get());
    }

    public ObservableField<String> getPhone() {
        return phone;
    }

    public void setPhone(ObservableField<String> pphone) {
        phone.set(pphone.get());
    }

    public ObservableBoolean getProgress() {
        return progress;
    }

    public void setProgress(ObservableBoolean pprogress) {
        progress.set(pprogress.get());
    }

    public ObservableField<String> getSumBuy() {
        return sumBuy;
    }

    public void setSumBuy(ObservableField<String> psumBuy) {
        sumBuy.set(psumBuy.get());
    }
}

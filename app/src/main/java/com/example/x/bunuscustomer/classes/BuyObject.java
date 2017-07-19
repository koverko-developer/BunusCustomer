package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by mobi app on 03.07.2017.
 */

public class BuyObject extends BaseObservable {

    private ObservableDouble price;
    private ObservableField<String> id;
    private ObservableInt col_friends;
    private ObservableInt col_balls;
    private ObservableDouble sale;
    private ObservableInt col_buy;
    private ObservableDouble itogo;

    public BuyObject(){
        price = new ObservableDouble();
        id = new ObservableField<>();
        col_friends = new ObservableInt();
        col_balls = new ObservableInt();
        sale = new ObservableDouble();
        col_buy = new ObservableInt();
        itogo = new ObservableDouble();
    }

    public ObservableDouble getPrice() {
        return price;
    }

    public void setPrice(ObservableDouble pprice) {
        price.set(pprice.get());
    }

    public ObservableField<String> getId() {
        return id;
    }

    public void setId(ObservableField<String> pid) {
        id.set(pid.get());
    }

    public ObservableInt getCol_friends() {
        return col_friends;
    }

    public void setCol_friends(ObservableInt pcol_friends) {
        col_friends.set(pcol_friends.get());
    }

    public ObservableInt getCol_balls() {
        return col_balls;
    }

    public void setCol_balls(ObservableInt pcol_balls) {
        col_balls.set(pcol_balls.get());
    }

    public ObservableDouble getSale() {
        return sale;
    }

    public void setSale(ObservableDouble psale) {
        sale.set(psale.get());
    }

    public ObservableInt getCol_buy() {
        return col_buy;
    }

    public void setCol_buy(ObservableInt pcol_buy) {
        col_buy.set(pcol_buy.get());
    }

    public ObservableDouble getItogo() {
        return itogo;
    }

    public void setItogo(ObservableDouble pitogo) {
        itogo.set(pitogo.get());
    }
}

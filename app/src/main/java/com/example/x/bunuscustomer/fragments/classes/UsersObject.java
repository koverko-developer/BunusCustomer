package com.example.x.bunuscustomer.fragments.classes;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by mobi app on 01.07.2017.
 */

public class UsersObject extends BaseObservable {

    private ObservableField<String> id;
    private ObservableField<String> col_buy;
    private ObservableField<String> ids;
    private ObservableField<String> fio;

    public UsersObject(){
        id = new ObservableField<>();
        col_buy = new ObservableField<>();
        ids = new ObservableField<>();
        fio = new ObservableField<>();
    }

    public ObservableField<String> getId() {
        return id;
    }

    public void setId(ObservableField<String> pid) {
        id.set("VTEME2017" +pid.get());
    }

    public ObservableField<String> getCol_buy() {
        return col_buy;
    }

    public ObservableField<String> getIds() {
        return ids;
    }

    public void setIds(ObservableField<String> pids) {
        ids.set(pids.get());
    }


    public void setCol_buy(ObservableField<String> pcol_buy) {
        col_buy.set(pcol_buy.get() + " покупок");
    }

    public ObservableField<String> getFio() {
        return fio;
    }

    public void setFio(ObservableField<String> pfio) {
        fio.set(pfio.get());
    }
}

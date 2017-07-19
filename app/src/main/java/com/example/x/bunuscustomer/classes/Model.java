package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by x on 18.06.2017.
 */

@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})

public class Model extends BaseObservable {


    private ObservableArrayList<String> arrayList;
    private ObservableInt position ;
    private ObservableBoolean isShowSteps;

    String[] type = new String[]{"Фиксированная","Накопительная","От суммы покупки"};


    public ObservableInt getPosition() {
        return position;
    }

    public void setPosition(ObservableInt pposition) {
        position.set(pposition.get());
    }

    public Model(){
        arrayList = new ObservableArrayList<>();
        arrayList.add(0,"Фиксированная");
        arrayList.add(1,"Накопительная");
        position = new ObservableInt();
        isShowSteps = new ObservableBoolean(false);
    }

    public ObservableArrayList<String> getType() {
        return arrayList;
    }




    public ObservableBoolean getIsShowSteps() {
        if(position.get()==0) return new ObservableBoolean(false);
        else return new ObservableBoolean(true);
    }

}

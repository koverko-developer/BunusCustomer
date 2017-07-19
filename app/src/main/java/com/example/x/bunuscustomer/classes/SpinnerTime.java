package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.widget.Spinner;

/**
 * Created by x on 18.06.2017.
 */


@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
public class SpinnerTime extends BaseObservable {

    private ObservableArrayList<String> arrayList;
    private ObservableField<String> text = new ObservableField<>("");
    private ObservableInt position ;
    String[] type = new String[]{"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30",
            "04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30",
            "08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30",
            "12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30",
            "16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30",
            "20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};

    public ObservableInt getPosition() {
        return position;
    }

    public void setPosition(ObservableInt pposition) {
        position.set(pposition.get());
    }

    public SpinnerTime(){

        arrayList = new ObservableArrayList<>();
        arrayList.add(0,"10:00");
        arrayList.add(1,"12:00");
        position = new ObservableInt();


    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public ObservableField<String> getText() {
        return new ObservableField<>(type[position.get()]);
    }
}

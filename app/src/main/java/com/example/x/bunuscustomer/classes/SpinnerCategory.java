package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.widget.Spinner;

/**
 * Created by x on 18.06.2017.
 */

@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
public class SpinnerCategory extends BaseObservable {

    private ObservableArrayList<String> arrayList;
    private ObservableInt position ;
    String[] type = new String[]{"Одежда и обувь","Красота и здоровье","Техника и электроника",
                                "Бытовая химия, косметика","Зоотовары и услуги","Подарки,сувениры,посуда",
                                "Свадебные салоны и услуги","Авто-мотовело","Мебель и хозтовары","It-технологии",
                                "Досуг","Здравоохранение","Недвижимость","Услуги населению"};

    public ObservableInt getPosition() {
        return position;
    }

    public void setPosition(ObservableInt pposition) {
        position.set(pposition.get());
    }

    public SpinnerCategory(){

        arrayList = new ObservableArrayList<>();
        arrayList.add(0,"IT-технологии");
        arrayList.add(1,"Красота и здоровье");
        position = new ObservableInt();


    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }
}

package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by mobi app on 29.06.2017.
 */

public class TestObject extends BaseObservable {

    private ObservableField<String> email;

    public TestObject(){
        email = new ObservableField<>("");
    }

    public ObservableField<String> getEmail() {
        return email;
    }

    public void setEmail(ObservableField<String> pemail) {
        email.set(pemail.get());
    }
}

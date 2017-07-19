package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.TextView;

/**
 * Created by mobi app on 28.06.2017.
 */

public class TextSpinner extends BaseObservable {
    private ObservableField<String> text = new ObservableField<>("");

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(ObservableField<String> ptext) {
        text.set(ptext.get());
    }

    @BindingAdapter({"bind:txx"})
    public static void setImageUrl(TextView imageView, String url) {
       imageView.setText(url);
    }

}

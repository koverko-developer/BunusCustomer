package com.example.x.bunuscustomer.fragments.classes;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import com.google.zxing.qrcode.encoder.QRCode;

/**
 * Created by mobi app on 01.07.2017.
 */

public class BindLocalImage extends BaseObservable {


    @BindingAdapter({"bind:srcqr"})
    public static void setImageURI(ImageView imageView, ObservableField<Uri> uri) {
        try {
            imageView.setImageURI(uri.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

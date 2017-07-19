package com.example.x.bunuscustomer.fragments.classes;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableShort;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by mobi app on 01.07.2017.
 */

public class ActionObject extends BaseObservable {

    private ObservableField<String> time;
    private ObservableField<String> name;
    private ObservableField<String> img;
    private ObservableField<String> text;
    private ObservableBoolean isEdit;
    private ObservableField<Uri> bitmap;
    private ObservableBoolean isBitmap;
    private ObservableField<String> id;
    private ObservableBoolean isProgress;

    public ActionObject() {
        time = new ObservableField<>();
        name = new ObservableField<>();
        img = new ObservableField<>();
        text = new ObservableField<>();
        isEdit = new ObservableBoolean(false);
        bitmap = new ObservableField<>();
        isBitmap = new ObservableBoolean(false);
        id = new ObservableField<>();
        isProgress = new ObservableBoolean(false);
    }




    public ObservableField<Uri> getBitmap() {
        return bitmap;
    }

    public void setBitmap(ObservableField<Uri> pbitmap) {
        bitmap.set(pbitmap.get());
    }


    public ObservableField<String> getTime() {
        return time;
    }

    public void setTime(ObservableField<String> ptime) {
        time.set("до "+ptime.get());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> pname) {
        name.set(pname.get());
    }

    public ObservableField<String> getImg() {
        return img;
    }

    public void setImg(ObservableField<String> pimg) {
        img.set(pimg.get());
    }

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(ObservableField<String> ptext) {
        text.set(ptext.get());
    }

    public ObservableBoolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(ObservableBoolean pisEdit) {
        isEdit.set(pisEdit.get());
    }


    public ObservableBoolean getIsBitmap() {
        return isBitmap;
    }

    public void setIsBitmap(ObservableBoolean pisBitmap) {
        isBitmap.set(pisBitmap.get());
    }

    public ObservableField<String> getId() {
        return id;
    }

    public void setId(ObservableField<String> pid) {
        id.set(pid.get());
    }

    public ObservableBoolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(ObservableBoolean pisProgress) {
        isProgress.set(pisProgress.get());
    }

    @BindingAdapter({"android:src"})
    public static void setImageUrl(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }



}
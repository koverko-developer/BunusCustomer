package com.example.x.bunuscustomer.fragments.classes;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

import com.example.x.bunuscustomer.handlers.AddNewsHandler;

/**
 * Created by mobi app on 02.07.2017.
 */

public class AddNewsOblect extends BaseObservable {

    public ObservableBoolean isProgress;

    public AddNewsOblect(){
        isProgress = new ObservableBoolean(false);

    }

    public ObservableBoolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(ObservableBoolean isProgress) {
        this.isProgress = isProgress;
    }
}

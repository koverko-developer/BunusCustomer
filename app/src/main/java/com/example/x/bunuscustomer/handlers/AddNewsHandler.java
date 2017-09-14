package com.example.x.bunuscustomer.handlers;

import android.view.View;

import com.example.x.bunuscustomer.AddNewsActivity;
import com.example.x.bunuscustomer.fragments.FragmentAddNews;

/**
 * Created by mobi app on 01.07.2017.
 */

public class AddNewsHandler {

    FragmentAddNews fragmentAddNews;

    public AddNewsHandler(FragmentAddNews fragmentAddNews){
        this.fragmentAddNews = fragmentAddNews;
    }

    public void onClickPhoto(View v){
        //fragmentAddNews.selectImage();
        fragmentAddNews.showDialogSelectImage();
    }
    public void onClickUpdate(View v){
        fragmentAddNews.addNews();
    }
}

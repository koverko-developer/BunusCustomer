package com.example.x.bunuscustomer.handlers;

import android.view.View;

import com.example.x.bunuscustomer.fragments.FragmentListAction;

/**
 * Created by mobi app on 01.07.2017.
 */

public class ActionHandler {

    FragmentListAction fragmentListAction;
    int position;

    public ActionHandler(FragmentListAction fragmentListAction, int position) {
        this.fragmentListAction = fragmentListAction;
        this.position = position;
    }
    public void onClickBasket(View v){
        fragmentListAction.deleteFromList(position);
    }

    public void onClickEdit(View v){
        fragmentListAction.showDialog(position);
    }

    public void onClickPhoto(View v){
        //fragmentListAction.selectImage(position);
    }

    public void onClickUpdate(View v){

    }
}

package com.example.x.bunuscustomer.handlers;

import android.view.View;

import com.example.x.bunuscustomer.FragmentRegistrations;
import com.example.x.bunuscustomer.fragments.FragmentUpdateCompany;

/**
 * Created by mobi app on 01.07.2017.
 */

public class UpdateHandler {
    FragmentUpdateCompany fragmentRegistrations;

    public UpdateHandler(FragmentUpdateCompany fragmentRegistrations){
        this.fragmentRegistrations = fragmentRegistrations;
    }

    public void onClickText(View v){

    }

    public void onClickButton(View v){

    }

    public void onClickTextSpinner(View v){
        fragmentRegistrations.showPopupMenu(v);
    }

    public void onClickTextFriend(View v){
        fragmentRegistrations.clickFriend();
    }
    public void onClickTextSelect(View v){
        fragmentRegistrations.selectImage();
    }
    public void onClickTextOferta(View v){
        fragmentRegistrations.clickOferta();
    }

    public void onClickEdit(View v){
        fragmentRegistrations.reg();
    }

    public void onClickStep(View v){
        fragmentRegistrations.showDialog();
    }
}

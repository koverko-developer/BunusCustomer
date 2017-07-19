package com.example.x.bunuscustomer.handlers;

import android.view.View;

import com.example.x.bunuscustomer.FragmentRegistrations;

/**
 * Created by x on 18.06.2017.
 */

public class RegistrationHandler {

    FragmentRegistrations fragmentRegistrations;

    public RegistrationHandler(FragmentRegistrations fragmentRegistrations){
        this.fragmentRegistrations = fragmentRegistrations;
    }

    public void onClickText(View v){

    }

    public void onClickButton(View v){
        fragmentRegistrations.showDialogOferta();
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
    public void onClickReg(View v){
        fragmentRegistrations.reg();
    }

    public void onClickStep(View v){
       fragmentRegistrations.showDialog();
    }
}

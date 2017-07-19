package com.example.x.bunuscustomer.handlers;

import android.view.View;

import com.example.x.bunuscustomer.fragments.FragmentListUsers;

/**
 * Created by mobi app on 01.07.2017.
 */

public class ListUserHandler {

    FragmentListUsers fragmentListUsers;
    int position;

    public ListUserHandler(FragmentListUsers fragmentListUsers, int position){
        this.fragmentListUsers = fragmentListUsers;
        this.position = position;
    }

    public void onClickCard(View v){
       fragmentListUsers.start(position);
    }

}

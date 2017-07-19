package com.example.x.bunuscustomer.fragments.viewHolder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mobi app on 01.07.2017.
 */

public class UsersViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding bindings;
    public UsersViewHolder(View itemView) {
        super(itemView);
        bindings = DataBindingUtil.bind(itemView);
    }
    public ViewDataBinding getBindings(){
        return bindings;
    }

}
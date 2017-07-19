package com.example.x.bunuscustomer.fragments.adapter;

/**
 * Created by mobi app on 01.07.2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.x.bunuscustomer.*;
import com.example.x.bunuscustomer.fragments.FragmentListAction;
import com.example.x.bunuscustomer.fragments.FragmentListUsers;
import com.example.x.bunuscustomer.fragments.classes.UsersObject;
import com.example.x.bunuscustomer.fragments.viewHolder.UsersViewHolder;
import com.example.x.bunuscustomer.handlers.ListUserHandler;

import java.util.List;


/**
 * Created by mobi app on 01.07.2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder>{
    private Context context;
    private List<UsersObject> categoryObjectList;
    FragmentListUsers activity;

    public UsersAdapter(Context context, List<UsersObject> categoryObjectList, FragmentListUsers activity) {
        this.context = context;
        this.categoryObjectList = categoryObjectList;
        this.activity = activity;
    }
    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_user, parent, false);
        return new UsersViewHolder(view);
    }
    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        UsersObject object = categoryObjectList.get(position);
        ListUserHandler handler = new ListUserHandler(activity, position);
        holder.getBindings().setVariable(BR.handlerUsers, handler);

        holder.getBindings().setVariable(BR.usersInfo,object);
        holder.getBindings().executePendingBindings();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return categoryObjectList.size();
    }

}
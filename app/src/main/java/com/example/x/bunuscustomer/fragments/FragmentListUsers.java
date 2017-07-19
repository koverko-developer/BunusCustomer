package com.example.x.bunuscustomer.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.x.bunuscustomer.InfoShop;
import com.example.x.bunuscustomer.R;
import com.example.x.bunuscustomer.UserInfoActivity;
import com.example.x.bunuscustomer.fragments.adapter.ActionAdapter;
import com.example.x.bunuscustomer.fragments.adapter.UsersAdapter;
import com.example.x.bunuscustomer.fragments.classes.ActionObject;
import com.example.x.bunuscustomer.fragments.classes.UsersObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobi app on 01.07.2017.
 */


@SuppressLint("ValidFragment")
public class FragmentListUsers extends Fragment {

    View v;
    UsersAdapter actionAdapter;
    List<UsersObject> actionObjects = new ArrayList<>();
    InfoShop activity;


    public FragmentListUsers(InfoShop activity, List<UsersObject> list){
        this.activity = activity;
        this.actionObjects = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_users, container, false);



        setRecycler();

        return v;
    }

    private void setRecycler(){

        try {

            LinearLayout lin = (LinearLayout) v.findViewById(R.id.linListsActions);
            TextView tv = (TextView) v.findViewById(R.id.textView39);
            RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rvListAction);
            final LinearLayoutManager llm = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(llm);
            recyclerView.setHasFixedSize(true);
            if(actionObjects!=null)actionAdapter = new UsersAdapter(activity,actionObjects,this);
            if(actionObjects.size()==0){
                recyclerView.setVisibility(View.GONE);
                lin.setBackgroundColor(this.getResources().getColor(R.color.white));
                tv.setVisibility(View.VISIBLE);
                tv.setText("У вас нет ниодного клиента");
            }
            recyclerView.setAdapter(actionAdapter);

            //recyclerView.getAdapter().notifyDataSetChanged();
            String  s= "";
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void start(int position){
        Intent intent = new Intent(activity, UserInfoActivity.class);
        intent.putExtra("id", actionObjects.get(position).getId().get());
        startActivity(intent);
    }
}

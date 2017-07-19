package com.example.x.bunuscustomer.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.x.bunuscustomer.*;
import com.example.x.bunuscustomer.R;
import com.example.x.bunuscustomer.UserInfoActivity;
import com.example.x.bunuscustomer.fragments.classes.UserInfoObject;
import com.example.x.bunuscustomer.retrofit.App;
import com.example.x.bunuscustomer.retrofit.userInfo.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mobi app on 02.07.2017.
 */

public class FragmentUserInfo extends Fragment {

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_TOKEN = "token";
    private static final String APP_PREFERENCES_ID = "id";
    private static final String APP_PREFERENCES_PHONE = "phone";
    private static final String APP_PREFERENCES_IMG = "img";
    private SharedPreferences mSettings;


    View v;
    UserInfoActivity activity;
    String id;
    UserInfoObject object = new UserInfoObject();

    String myId, myToken;

    public FragmentUserInfo(UserInfoActivity activity, String id) {
        this.activity = activity;
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_info, container, false);

        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        myId = mSettings.getString(APP_PREFERENCES_ID,"");
        myToken = mSettings.getString(APP_PREFERENCES_TOKEN,"");
        id = id.substring(9,id.length());

        binding.setVariable(BR.usrInfoId, object);
        getUserInfo();
        v = binding.getRoot();
        return  v;
    }

    public void getUserInfo(){
        object.setProgress(new ObservableBoolean(true));
        App.getApi().getUserInfo(id,myId, myToken).enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                object.setProgress(new ObservableBoolean(false));
                UserInfo info = response.body().get(0);

                object.setFio(new ObservableField<String>(info.getMycompany().getUserinfo().getFio()));
                object.setBuyDate(new ObservableField<String>(info.getMycompany().getCompanyUser().getLastBuying()));
                object.setColFriend(new ObservableField<String>(info.getMycompany().getCompanyUser().getColFriend()));
                object.setColBuy(new ObservableField<String>(info.getMycompany().getCompanyUser().getColBuy()));
                object.setColBalls(new ObservableField<String>(info.getMycompany().getCompanyUser().getColBal()));
                object.setEmail(new ObservableField<String>(info.getMycompany().getUserinfo().getEmail()));
                object.setPhone(new ObservableField<String>(info.getMycompany().getUserinfo().getPhone()));
                object.setSumBuy(new ObservableField<String>(info.getMycompany().getCompanyUser().getSum_buy()));

                String s = "";

            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                object.setProgress(new ObservableBoolean(false));
                Toast.makeText(activity, "Проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

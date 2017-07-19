package com.example.x.bunuscustomer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.x.bunuscustomer.retrofit.App;
import com.example.x.bunuscustomer.retrofit.Otvet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    TextView regText;
    EditText login;
    EditText pass;
    Dialog dialogEdit = null;

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_TOKEN = "token";
    private static final String APP_PREFERENCES_ID = "id";
    private static final String APP_PREFERENCES_PHONE = "phone";
    private static final String APP_PREFERENCES_IMG = "img";
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        regText = (TextView) findViewById(R.id.textView5);
        regText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        login = (EditText) findViewById(R.id.editTextLog);
        pass = (EditText) findViewById(R.id.editTextPass);

        TextView tvEdShow = (TextView) findViewById(R.id.textView42);
        tvEdShow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEditPassword();
            }
        });

        TextView tvBusines = (TextView) findViewById(R.id.textViewBusines);
        Typeface type = Typeface.createFromAsset(this.getAssets(),"fonts/myfonts.ttf");
        tvBusines.setTypeface(type);

        Button btnAuth = (Button) findViewById(R.id.buttonSign);
        btnAuth.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                auth();
            }
        });

    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void auth(){

      try{
          String ss = pass.getText().toString();
          ss = ss.toLowerCase();
          String s = md5(ss);
          s = s.toLowerCase();
          App.getApi().login(login.getText().toString(), s).enqueue(new Callback<Otvet>() {
              @Override
              public void onResponse(Call<Otvet> call, Response<Otvet> response) {
                  //com.example.x.bunuscustomer.retrofit.Response otvet = response.body();
                  if(Integer.parseInt(response.body().getCode())==201){

                      SharedPreferences.Editor editor = mSettings.edit();
                      editor.putString(APP_PREFERENCES_TOKEN, response.body().getMessage());
                      editor.putString(APP_PREFERENCES_ID, response.body().getStatus());
                      editor.apply();
                      startActivity(new Intent(LoginActivity.this, BuyActivity.class));

                  }else toast("Ошибка авторизации...");

              }

              @Override
              public void onFailure(Call<Otvet> call, Throwable t) {
                  toast("Проверьте подключение к интернету...");
              }
          });

      }catch (Exception e){
          e.printStackTrace();
      }

    }

    public void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showDialogEditPassword(){

        dialogEdit = new Dialog(this);
        dialogEdit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEdit.setContentView(R.layout.alert_edit_password);


        TextView tvSend = (TextView) dialogEdit.findViewById(R.id.textView44);
        final EditText email = (EditText) dialogEdit.findViewById(R.id.editTextEmailEditP);


        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail(email.getText().toString());
                //dialogEdit.dismiss();
            }
        });



        dialogEdit.show();
    }

    public void sendEmail(String email){
        App.getApi().sendEmail(email).enqueue(new Callback<Otvet>() {
            @Override
            public void onResponse(Call<Otvet> call, Response<Otvet> response) {
                switch (Integer.parseInt(response.body().getCode())){
                    case 201:
                        toast(response.body().getMessage());
                        dialogEdit.dismiss();
                        break;
                    case 202:
                        toast(response.body().getMessage());
                        break;
                    case 203:
                        toast(response.body().getMessage());
                        dialogEdit.dismiss();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Otvet> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


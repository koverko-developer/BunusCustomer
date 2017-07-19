package com.example.x.bunuscustomer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        ImageView imgHome = (ImageView) findViewById(R.id.imageViewHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Set up the login form.
        Fragment fragment = new FragmentRegistrations(this);
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void toast(String s){
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }
    public void toastEr(){
        Toast.makeText(this,"Проверьте подключение к интернету...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                // do what you want to be done on home button click event
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void progress(){
        if(progressBar.getVisibility()==View.VISIBLE) progressBar.setVisibility(View.GONE);
        else progressBar.setVisibility(View.VISIBLE);
    }

}


package com.example.x.bunuscustomer.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.bunuscustomer.AddNewsActivity;
import com.example.x.bunuscustomer.InfoShop;
import com.example.x.bunuscustomer.R;
import com.example.x.bunuscustomer.fragments.adapter.ActionAdapter;
import com.example.x.bunuscustomer.fragments.classes.ActionObject;
import com.example.x.bunuscustomer.retrofit.App;
import com.example.x.bunuscustomer.retrofit.Otvet;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mobi app on 01.07.2017.
 */

@SuppressLint("ValidFragment")
public class FragmentListAction extends Fragment {

    private static final int RESULT_SELECT_IMAGE = 1;
    View v;
    ActionAdapter actionAdapter;
    List<ActionObject> actionObjects = new ArrayList<>();
    InfoShop activity;
    RecyclerView recyclerView;
    int position = 0;
    Dialog dialog = null;
    ImageView img1;
    ImageView img2;
    String bitmapS = "";
    Uri image;
    int count = 0;

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_TOKEN = "token";
    private static final String APP_PREFERENCES_ID = "id";
    private static final String APP_PREFERENCES_PHONE = "phone";
    private static final String APP_PREFERENCES_IMG = "img";
    private SharedPreferences mSettings;
    String myId;

    public FragmentListAction(InfoShop activity, List<ActionObject> list){
        this.activity = activity;
        this.actionObjects = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_action, container, false);

        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        myId = mSettings.getString(APP_PREFERENCES_ID,"");

        //setRecycler();

        return v;
    }

    private void setRecycler(){

        try {

//            if(actionObjects.size()!=0) actionObjects.clear();

            LinearLayout lin = (LinearLayout) v.findViewById(R.id.linListsActions);
            TextView tv = (TextView) v.findViewById(R.id.textView39);
            recyclerView = (RecyclerView) v.findViewById(R.id.rvListAction);
            final LinearLayoutManager llm = new LinearLayoutManager(activity);
            recyclerView.setLayoutManager(llm);
            recyclerView.setHasFixedSize(true);
            if(actionObjects!=null)actionAdapter = new ActionAdapter(activity,actionObjects,this);
            if(actionObjects.size()==0){
                recyclerView.setVisibility(View.GONE);
                lin.setBackgroundColor(this.getResources().getColor(R.color.white));
                tv.setVisibility(View.VISIBLE);
            }
           recyclerView.setAdapter(actionAdapter);
            //recyclerView.getAdapter().notifyDataSetChanged();



            String  s= "";
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editable(int position){
        if(actionObjects.get(position).getIsEdit().get()) actionObjects.get(position).setIsEdit(new ObservableBoolean(false));
        else actionObjects.get(position).setIsEdit(new ObservableBoolean(true));

        if(actionObjects.get(position).getBitmap()!=null){

        }else {
            if(actionObjects.get(position).getIsBitmap().get()) actionObjects.get(position).setIsBitmap(new ObservableBoolean(false));
            else actionObjects.get(position).setIsBitmap(new ObservableBoolean(true));
        }
    }



    public void selectImage(){

        Intent gallaryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallaryIntent, RESULT_SELECT_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_SELECT_IMAGE && resultCode == RESULT_OK && data != null){
            //set the selected image to image variable
            image = data.getData();
            String img = image.toString();
            img1.setImageURI(image);
            img2.setVisibility(View.GONE);
            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), image);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //compress the image to jpg format
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                String encodeImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
                bitmapS = encodeImage;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateAction(final int position, final String time, final String title, final String text){

        App.getApi().updateNews(time,myId,
                actionObjects.get(position).getId().get(),
                title,
                text,
                bitmapS).enqueue(new Callback<Otvet>() {
            @Override
            public void onResponse(Call<Otvet> call, Response<Otvet> response) {
//                actionObjects.get(position).setTime(new ObservableField<String>(time));
//                actionObjects.get(position).setName(new ObservableField<String>(title));
//                actionObjects.get(position).setText(new ObservableField<String>(text));
//                actionObjects.get(position).setBitmap(new ObservableField<Uri>(image));
                activity.update();

            }

            @Override
            public void onFailure(Call<Otvet> call, Throwable t) {

            }
        });

    }

    public void showDialog(final int position){

        dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_edit_news);

        final EditText edName = (EditText) dialog.findViewById(R.id.editText9);
        final EditText edTime = (EditText) dialog.findViewById(R.id.editText7);
        final EditText edDescription = (EditText) dialog.findViewById(R.id.textView27);
        img1 = (ImageView) dialog.findViewById(R.id.imageView19);
        img2 = (ImageView) dialog.findViewById(R.id.imageView6);
        ImageView imgClose = (ImageView) dialog.findViewById(R.id.imageView22);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFromList(position);
                dialog.dismiss();
            }
        });

        ImageView imgDone = (ImageView) dialog.findViewById(R.id.imageView21);
        imgDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String time = edTime.getText().toString().replaceAll("до","");
                time = time.replaceAll("До","");
                dialog.dismiss();
                Toast.makeText(activity, "Ваши изменения отправлены на модерацию",Toast.LENGTH_SHORT).show();
                updateAction(position,time,
                        edName.getText().toString(),
                        edDescription.getText().toString());

            }
        });
        ImageView imgPhoto = (ImageView) dialog.findViewById(R.id.imageView10);
        imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
        try{
            Picasso.with(img2.getContext())
                    .load(actionObjects.get(position).getImg().get())
                    .into(img2);
        }catch (Exception e){
            e.printStackTrace();
        }
        //img1.setImageURI();

        edName.setText(actionObjects.get(position).getName().get());
        edTime.setText(actionObjects.get(position).getTime().get());
        edDescription.setText(actionObjects.get(position).getText().get());



        dialog.show();

    }

    public void deleteFromList(final int position){

        App.getApi().deleteNews(actionObjects.get(position).getId().get()).enqueue(new Callback<Otvet>() {
            @Override
            public void onResponse(Call<Otvet> call, Response<Otvet> response) {
                //activity.update();'
                try {
                    activity.update();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Otvet> call, Throwable t) {
                Toast.makeText(activity, "Проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        try {

            if(count<1)setRecycler();
            count++;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //actionObjects.clear();
    }
}

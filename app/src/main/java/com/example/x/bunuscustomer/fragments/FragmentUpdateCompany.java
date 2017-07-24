package com.example.x.bunuscustomer.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.bunuscustomer.*;
import com.example.x.bunuscustomer.InfoShop;
import com.example.x.bunuscustomer.R;
import com.example.x.bunuscustomer.RegistrationActivity;
import com.example.x.bunuscustomer.UpdateCompanyActivity;
import com.example.x.bunuscustomer.classes.Model;
import com.example.x.bunuscustomer.classes.OrganizationsObject;
import com.example.x.bunuscustomer.classes.SpinnerCategory;
import com.example.x.bunuscustomer.classes.SpinnerTime;
import com.example.x.bunuscustomer.classes.TestObject;
import com.example.x.bunuscustomer.fragments.classes.ActionObject;
import com.example.x.bunuscustomer.fragments.classes.UsersObject;
import com.example.x.bunuscustomer.handlers.RegistrationHandler;
import com.example.x.bunuscustomer.handlers.UpdateHandler;
import com.example.x.bunuscustomer.retrofit.App;
import com.example.x.bunuscustomer.retrofit.CompanyUser;
import com.example.x.bunuscustomer.retrofit.InfoCompany;
import com.example.x.bunuscustomer.retrofit.News;
import com.example.x.bunuscustomer.retrofit.Otvet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mobi app on 01.07.2017.
 */

public class FragmentUpdateCompany extends Fragment{

    OrganizationsObject organizationsObjectReg;
    TestObject testObject = new TestObject();
    SpinnerCategory spinnerCategory = new SpinnerCategory();
    SpinnerTime spinnerTime = new SpinnerTime();
    SpinnerTime spinnerTime2 = new SpinnerTime();
    Model model = new Model();
    UpdateHandler handler;
    private static final int RESULT_SELECT_IMAGE = 1;
    LinearLayout view;

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_TOKEN = "token";
    private static final String APP_PREFERENCES_ID = "id";
    private static final String APP_PREFERENCES_PHONE = "phone";
    private static final String APP_PREFERENCES_IMG = "img";
    private SharedPreferences mSettings;

    UpdateCompanyActivity activity;
    View v;

    String myId = "";
    String myToken = "";


    public FragmentUpdateCompany(UpdateCompanyActivity activity){
        this.activity = activity;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_company, container, false);

        organizationsObjectReg = new OrganizationsObject();
        handler = new UpdateHandler(this);
        binding.setVariable(BR.organizationObjectRegs, organizationsObjectReg);
        binding.setVariable(BR.test,testObject);
        binding.setVariable(BR.spinnerCategory, spinnerCategory);
        binding.setVariable(BR.spinnerTime1,spinnerTime);
        binding.setVariable(BR.spinnerTime2,spinnerTime2);
        binding.setVariable(BR.handlerUpdate,handler);

        binding.setVariable(BR.spinnerLoyality, model);

        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        myId = mSettings.getString(APP_PREFERENCES_ID,"");
        myToken = mSettings.getString(APP_PREFERENCES_TOKEN,"");

        getInfo();

        v = binding.getRoot();
        return  v;
    }
    public void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this.getActivity(), v);
        popupMenu.inflate(R.menu.popupmenu); // Для Android 4.0
        // для версии Android 3.0 нужно использовать длинный вариант
        // popupMenu.getMenuInflater().inflate(R.menu.popupmenu,
        // popupMenu.getMenu());

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Toast.makeText(PopupMenuDemoActivity.this,
                        // item.toString(), Toast.LENGTH_LONG).show();
                        // return true;
                        switch (item.getItemId()) {

                            case R.id.menu1:
                                organizationsObjectReg.setLoyalty_id(new ObservableInt(1));
                                organizationsObjectReg.setLoyalty_text(new ObservableField<String>("Фиксированная"));
                                organizationsObjectReg.setLoyalty_is(new ObservableBoolean(true));
                                return true;
                            case R.id.menu2:
                                organizationsObjectReg.setLoyalty_id(new ObservableInt(2));
                                organizationsObjectReg.setLoyalty_text(new ObservableField<String>("От суммы покупки"));
                                organizationsObjectReg.setLoyalty_is(new ObservableBoolean(false));

                                return true;
                            case R.id.menu3:
                                organizationsObjectReg.setLoyalty_id(new ObservableInt(3));
                                organizationsObjectReg.setLoyalty_text(new ObservableField<String>("Накопительная"));
                                organizationsObjectReg.setLoyalty_is(new ObservableBoolean(false));
                                return true;

                            default:
                                return false;
                        }
                    }
                });


        popupMenu.show();
    }

    public void clickFriend(){
        if(organizationsObjectReg.getIsFriend().get()) organizationsObjectReg.setIsFriend(new ObservableBoolean(false));
        else organizationsObjectReg.setIsFriend(new ObservableBoolean(true));
    }

    public void clickOferta(){
        if(organizationsObjectReg.getIsOferta().get()) organizationsObjectReg.setIsOferta(new ObservableBoolean(false));
        else organizationsObjectReg.setIsOferta(new ObservableBoolean(true));
    }

    public void selectImage(){
        //open album to select image
        Intent gallaryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallaryIntent, RESULT_SELECT_IMAGE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_SELECT_IMAGE && resultCode == RESULT_OK && data != null){
            //set the selected image to image variable
            Uri image = data.getData();
            String img = image.toString();
            //adveristing.setImg(new ObservableField<Uri>(image));
            organizationsObjectReg.setBitmap(new ObservableField<Uri>(image));
            organizationsObjectReg.setIsImg(new ObservableBoolean(true));
            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), image);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //compress the image to jpg format
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            /*
            * encode image to base64 so that it can be picked by saveImage.php file
            * */
                String encodeImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
                organizationsObjectReg.setImage(new ObservableField<String>(encodeImage));
                Toast.makeText(activity, "Фото добавлено, на модерации...", Toast.LENGTH_SHORT).show();
                //adveristing.setBitmap(new ObservableField<String>(encodeImage));
               // organizationsObjectReg.setImage(new ObservableField<String>(encodeImage));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            imageView.setImageURI(image);
//            imageViewOb.setImageURI(image);

        }
    }

    public void reg(){
        if(!getValid()){
        }else{
            Toast.makeText(activity,"Данные отправлены на модерацию.",Toast.LENGTH_SHORT).show();
            activity.onBackPressed();
            String pass = "";
            if(organizationsObjectReg.getPassword1().get().isEmpty()) pass = "1234567";
            else pass = md5(organizationsObjectReg.getPassword1().get());
            String time1 = spinnerTime.getType()[spinnerTime.getPosition().get()];
            String time2 = spinnerTime2.getType()[spinnerTime2.getPosition().get()];
            //activity.progress();
            App.getApi().updateCompany(
                    organizationsObjectReg.getName().get(),
                    organizationsObjectReg.getIndex().get(),
                    organizationsObjectReg.getCity().get(),
                    organizationsObjectReg.getStreet().get(),
                    organizationsObjectReg.getHome().get(),
                    organizationsObjectReg.getKv().get(),
                    spinnerCategory.getPosition().get(),
                    time1,
                    time2,
                    organizationsObjectReg.getPhone().get(),
                    String.valueOf(organizationsObjectReg.getLoyalty_id().get()),
                    organizationsObjectReg.getFixed_price().get(),
                    organizationsObjectReg.getFriend_frice().get(),
                    pass,
                    organizationsObjectReg.getImage().get(),
                    organizationsObjectReg.getBuy1().get(),
                    organizationsObjectReg.getBuy2().get(),
                    organizationsObjectReg.getBuy3().get(),
                    organizationsObjectReg.getBuy4().get(),
                    organizationsObjectReg.getProc1().get(),
                    organizationsObjectReg.getProc2().get(),
                    organizationsObjectReg.getProc3().get(),
                    organizationsObjectReg.getProc4().get(),
                    myId,myToken


            ).enqueue(new Callback<Otvet>() {
                @Override
                public void onResponse(Call<Otvet> call, Response<Otvet> response) {
                    Otvet otvet = response.body();


                }

                @Override
                public void onFailure(Call<Otvet> call, Throwable t) {
                    Toast.makeText(activity,"Проверьте подключение к интернету...",Toast.LENGTH_SHORT).show();

                }
            });
        }
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

    public void showDialog(){

        final Dialog dialog = new Dialog(this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_steps);

        final EditText step1 = (EditText) dialog.findViewById(R.id.editText5);
        final EditText step2 = (EditText) dialog.findViewById(R.id.editText4);
        final EditText step3 = (EditText) dialog.findViewById(R.id.editText3);
        final EditText step4 = (EditText) dialog.findViewById(R.id.editText);

        final EditText proc1 = (EditText) dialog.findViewById(R.id.editText52);
        final EditText proc2 = (EditText) dialog.findViewById(R.id.editText41);
        final EditText proc3 = (EditText) dialog.findViewById(R.id.editText31);
        final EditText proc4 = (EditText) dialog.findViewById(R.id.editText2);

        TextView tvDONE = (TextView) dialog.findViewById(R.id.textView15);
        TextView tvClose = (TextView) dialog.findViewById(R.id.textView14);

        tvDONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                organizationsObjectReg.setBuy1(new ObservableField<String>(step1.getText().toString()));
                organizationsObjectReg.setBuy2(new ObservableField<String>(step2.getText().toString()));
                organizationsObjectReg.setBuy3(new ObservableField<String>(step3.getText().toString()));
                organizationsObjectReg.setBuy4(new ObservableField<String>(step4.getText().toString()));

                organizationsObjectReg.setProc1(new ObservableField<String>(proc1.getText().toString()));
                organizationsObjectReg.setProc2(new ObservableField<String>(proc2.getText().toString()));
                organizationsObjectReg.setProc3(new ObservableField<String>(proc3.getText().toString()));
                organizationsObjectReg.setProc4(new ObservableField<String>(proc4.getText().toString()));

                dialog.dismiss();
            }
        });

        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



        dialog.show();

    }

    public boolean getValid(){
        boolean x = true;
        if(organizationsObjectReg.getPassword1().get().equals(organizationsObjectReg.getPassword2().get())) {}
        else {
            Toast.makeText(activity,"Пароли должны совпадать...", Toast.LENGTH_SHORT).show();
            x = false;

        }
        if(organizationsObjectReg.getEmail().get()!=""){}
        else {
            Toast.makeText(activity,"E-mail не может быть пустым...", Toast.LENGTH_SHORT).show();
            x = false;
        }

        return x;
    }

    public void getInfo(){
        App.getApi().getInfoCompany(myId, myToken).enqueue(new Callback<List<InfoCompany>>() {
            @Override
            public void onResponse(Call<List<InfoCompany>> call, Response<List<InfoCompany>> response) {
                List<InfoCompany> list = response.body();
                InfoCompany infoCompany = list.get(0);

                organizationsObjectReg.setIndex(new ObservableField<String>(infoCompany.getMycompany().getCity().getIndex()));
                organizationsObjectReg.setCity(new ObservableField<String>(infoCompany.getMycompany().getCity().getCity()));
                organizationsObjectReg.setStreet(new ObservableField<String>(infoCompany.getMycompany().getCity().getAddress()));
                organizationsObjectReg.setHome(new ObservableField<String>(infoCompany.getMycompany().getCity().getBuild()));
                organizationsObjectReg.setKv(new ObservableField<String>(infoCompany.getMycompany().getCity().getOffice()));
                organizationsObjectReg.setName(new ObservableField<String>(infoCompany.getMycompany().getName()));
                //spinnerCategory.setPosition(new ObservableInt(Integer.parseInt(infoCompany.getMycompany().getCategoryId().g)));
                organizationsObjectReg.setEmail(new ObservableField<String>(infoCompany.getMycompany().getEmail()));
                spinnerCategory.setPosition(new ObservableInt(Integer.parseInt(infoCompany.getMycompany().getCategoryId().getId())));
                organizationsObjectReg.setPhone(new ObservableField<String>(infoCompany.getMycompany().getTelephone()));
                if(Integer.parseInt(infoCompany.getMycompany().getLoyaltyId())==1) {
                    organizationsObjectReg.setLoyalty_id(new ObservableInt(1));
                    organizationsObjectReg.setLoyalty_text(new ObservableField<String>("Фиксированная"));
                    organizationsObjectReg.setLoyalty_is(new ObservableBoolean(true));
                    organizationsObjectReg.setFixed_price(new ObservableField<String>(infoCompany.getMycompany().getSale()));
                }else if(Integer.parseInt(infoCompany.getMycompany().getLoyaltyId())==2) {
                    organizationsObjectReg.setLoyalty_id(new ObservableInt(2));
                    organizationsObjectReg.setLoyalty_text(new ObservableField<String>("От суммы покупок"));
                    organizationsObjectReg.setLoyalty_is(new ObservableBoolean(false));

                    organizationsObjectReg.setBuy1(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep1Col()));
                    organizationsObjectReg.setBuy2(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep2Col()));
                    organizationsObjectReg.setBuy3(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep3Col()));
                    organizationsObjectReg.setBuy4(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep4Col()));

                    organizationsObjectReg.setProc1(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep1()));
                    organizationsObjectReg.setProc2(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep2()));
                    organizationsObjectReg.setProc3(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep3()));
                    organizationsObjectReg.setProc4(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep4()));
                }else {
                    organizationsObjectReg.setLoyalty_id(new ObservableInt(3));
                    organizationsObjectReg.setLoyalty_text(new ObservableField<String>("Накопительная"));
                    organizationsObjectReg.setLoyalty_is(new ObservableBoolean(false));

                    organizationsObjectReg.setBuy1(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep1Col()));
                    organizationsObjectReg.setBuy2(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep2Col()));
                    organizationsObjectReg.setBuy3(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep3Col()));
                    organizationsObjectReg.setBuy4(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep4Col()));

                    organizationsObjectReg.setProc1(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep1()));
                    organizationsObjectReg.setProc2(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep2()));
                    organizationsObjectReg.setProc3(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep3()));
                    organizationsObjectReg.setProc4(new ObservableField<String>(infoCompany.getMycompany().getLoyaltyStep().getStep4()));
                }
                if(Double.parseDouble(infoCompany.getMycompany().getInvitePrice())==0){}
                else {
                    organizationsObjectReg.setIsFriend(new ObservableBoolean(false));
                    organizationsObjectReg.setFriend_frice(new ObservableField<String>(infoCompany.getMycompany().getInvitePrice()));
                }

            }

            @Override
            public void onFailure(Call<List<InfoCompany>> call, Throwable t) {
                Toast.makeText(activity,"Проверьте подключение к инткрнету...",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

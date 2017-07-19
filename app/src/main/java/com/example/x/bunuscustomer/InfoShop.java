package com.example.x.bunuscustomer;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.bunuscustomer.fragments.FragmentListAction;
import com.example.x.bunuscustomer.fragments.FragmentListUsers;
import com.example.x.bunuscustomer.fragments.classes.ActionObject;
import com.example.x.bunuscustomer.fragments.classes.UsersObject;
import com.example.x.bunuscustomer.retrofit.App;
import com.example.x.bunuscustomer.retrofit.CompanyUser;
import com.example.x.bunuscustomer.retrofit.InfoCompany;
import com.example.x.bunuscustomer.retrofit.News;
import com.example.x.bunuscustomer.retrofit.Otvet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoShop extends AppCompatActivity {

    private static final String APP_PREFERENCES = "config";
    private static final String APP_PREFERENCES_TOKEN = "token";
    private static final String APP_PREFERENCES_ID = "id";
    private static final String APP_PREFERENCES_PHONE = "phone";
    private static final String APP_PREFERENCES_IMG = "img";
    private SharedPreferences mSettings;

    List<ActionObject> listAction = new ArrayList<>();
    List<UsersObject> listUsers = new ArrayList<>();

    TabLayout tabLayout;

    ImageView imgLogo,imgCategory;
    TextView textCategory, nameCompany,textTime, textPhone, textAddress;

    String myId = "";
    String myToken = "";
    RelativeLayout relProgressInfoShops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_shop);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        myId = mSettings.getString(APP_PREFERENCES_ID,"");
        myToken = mSettings.getString(APP_PREFERENCES_TOKEN,"");

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("АКЦИИ"));
        tabLayout.addTab(tabLayout.newTab().setText("КЛИЕНТЫ"));

        CardView card= (CardView) findViewById(R.id.cardSkidka);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InfoShop.this, UpdateCompanyActivity.class));

            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageViewInfoHome);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        relProgressInfoShops = (RelativeLayout) findViewById(R.id.relProgressShops);

        //getInfo();

    }

    public void getInfo(){

//        if(listAction.size()!=0) listAction.clear();
//        if(listUsers.size()!=0) listUsers.clear();
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        tab.select();
        relProgressInfoShops.setVisibility(View.VISIBLE);
        App.getApi().getInfoCompany(myId, myToken).enqueue(new Callback<List<InfoCompany>>() {
            @Override
            public void onResponse(Call<List<InfoCompany>> call, Response<List<InfoCompany>> response) {
                List<InfoCompany> list = response.body();
                InfoCompany infoCompany = list.get(0);

                List<News> news = infoCompany.getMycompany().getNews();
                List<CompanyUser> users = infoCompany.getMycompany().getCompanyUser();

                for(int i = 0; i< news.size(); i++){
                    ActionObject object = new ActionObject();
                    object.setName(new ObservableField<String>(news.get(i).getTitle()));
                    object.setTime(new ObservableField<String>(news.get(i).getTime()));
                    object.setImg(new ObservableField<String>(news.get(i).getPhoto()));
                    object.setText(new ObservableField<String>(news.get(i).getText()));
                    object.setId(new ObservableField<String>(news.get(i).getId()));

                    listAction.add(object);
                }

                for (int i = 0; i< users.size(); i++){

                    UsersObject object = new UsersObject();
                    object.setId(new ObservableField<String>(users.get(i).getIdUser()));
                    object.setCol_buy(new ObservableField<String>(users.get(i).getColBuy()));
                    object.setIds(new ObservableField<String>(String.valueOf(i+1)+"."));
                    //object.setFio(new ObservableField<String>(users.get(i).));

                    listUsers.add(object);

                }

                int status_news = Integer.parseInt(infoCompany.getMycompany().getStatusNews());

                String address = infoCompany.getMycompany().getCity().getIndex()+ ", Республика Беларусь, \nг." +infoCompany.getMycompany().getCity().getCity()
                        +" , ул."+infoCompany.getMycompany().getCity().getAddress()+" "+ infoCompany.getMycompany().getCity().getBuild();
                if(infoCompany.getMycompany().getCity().getOffice().length()>0) address = address + ",офис "+ infoCompany.getMycompany().getCity().getOffice();


                setInfo(infoCompany.getMycompany().getImage(), infoCompany.getMycompany().getName(),
                        infoCompany.getMycompany().getCategoryId().getIcon(),infoCompany.getMycompany().getCategoryId().getCompanyCategory(),
                        infoCompany.getMycompany().getTime(),infoCompany.getMycompany().getTelephone(),address,
                        status_news
                        );

                String s = "";
                relProgressInfoShops.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<InfoCompany>> call, Throwable t) {

                //relProgressInfoShops.setVisibility(View.GONE);
                Toast.makeText(InfoShop.this,"Проверьте подключение к инткрнету...",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void update(){
        listAction.clear();
        listUsers.clear();
        getInfo();
    }

    public void setInfo(String logoCompany, String nCompany, String logoCategory, String nameCategory,
                        String timeCompany, String phoneCompany, String address, final int status_n){




        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        imgLogo = (ImageView) findViewById(R.id.imageViewLogoInfo);
        try {
            Picasso.with(imgLogo.getContext())
                    .load(logoCompany)
                    .into(imgLogo);
        }catch (Exception e){
            e.printStackTrace();
        }
        imgCategory = (ImageView) findViewById(R.id.imageViewLogoCategory);
        Picasso.with(imgCategory.getContext())
                .load(logoCategory)
                .into(imgCategory);
        textCategory = (TextView) findViewById(R.id.textViewNameCategory);
        textCategory.setText(nameCategory);

        nameCompany = (TextView) findViewById(R.id.textViewNameCompany);
        nameCompany.setText(nCompany);

        textTime = (TextView) findViewById(R.id.textViewTimeCompany);
        textTime.setText(timeCompany);

        textPhone = (TextView) findViewById(R.id.textViewPhoneCompany);
        textPhone.setText(phoneCompany);

        textAddress = (TextView) findViewById(R.id.textViewTextAdddress);
        textAddress.setText(address);


        CardView btn = (CardView) findViewById(R.id.button6);
        if(status_n==1) btn.setCardBackgroundColor(getResources().getColor(R.color.xz));
        else btn.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status_n==0) startActivity(new Intent(InfoShop.this, AddNewsActivity.class));
                else if(status_n==1) showDialog("1");
                else showDialog("2");
            }
        });


        initViewPager();

    }

    public void initViewPager(){
        try {
            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            final PagerAdapter adapter = new PagerAdapter
                    (getSupportFragmentManager(), tabLayout.getTabCount(), listAction, listUsers);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        List<ActionObject> list;
        List<UsersObject> usersObjectList;

        public PagerAdapter(FragmentManager fm, int NumOfTabs, List<ActionObject> list, List<UsersObject> usersObjectList) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
            this.list = list;
            this.usersObjectList = usersObjectList;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    FragmentListAction tab1 = new FragmentListAction(InfoShop.this, listAction);
                    return tab1;
                case 1:
                    FragmentListUsers tab2 = new FragmentListUsers(InfoShop.this, usersObjectList);
                    return tab2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

    public void showDialog(String s){

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_news);


        TextView text = (TextView) dialog.findViewById(R.id.textView36);
        if(Integer.parseInt(s)==1) text.setText(getResources().getString(R.string.text_news));
        else text.setText(getResources().getString(R.string.text_news_2));
        TextView tvDONE = (TextView) dialog.findViewById(R.id.textView37);
        TextView tvClose = (TextView) dialog.findViewById(R.id.textView38);

        tvDONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
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

    public void sendMessage(){
        App.getApi().sendAddNews(myId, myToken).enqueue(new Callback<Otvet>() {
            @Override
            public void onResponse(Call<Otvet> call, Response<Otvet> response) {
                Toast.makeText(InfoShop.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Otvet> call, Throwable t) {
                Toast.makeText(InfoShop.this,"Проверьте подключение к инткрнету...",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        try{
           update();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

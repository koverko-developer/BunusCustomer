package com.example.x.bunuscustomer.retrofit;

import com.example.x.bunuscustomer.retrofit.buyQR.QrExample;
import com.example.x.bunuscustomer.retrofit.userInfo.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mobi app on 28.06.2017.
 */

public interface Api {

    @FormUrlEncoded
    @POST("bonus/reg_company.php")
    Call<Otvet> regisnrations(@Field("login") String login,
                              @Field("name") String name,
                              @Field("index") String index,
                              @Field("city") String city,
                              @Field("address") String address,
                              @Field("build") String build,
                              @Field("office") String office,
                              @Field("company_category") int company_category,
                              @Field("time_open") String time_open,
                              @Field("time_close") String time_close,
                              @Field("telephone") String telephone,
                              @Field("loyalty_id") String loyalty_id,
                              @Field("sale") String sale,
                              @Field("invite_price") String invite_price,
                              @Field("password") String password,
                              @Field("image") String image,
                              @Field("step1_col") String step1_col,
                              @Field("step2_col") String step2_col,
                              @Field("step3_col") String step3_col,
                              @Field("step4_col") String step4_col,
                              @Field("step1") String step1,
                              @Field("step2") String step2,
                              @Field("step3") String step3,
                              @Field("step4") String step4,
                              @Field("unp") String unp,
                              @Field("date") String date,
                              @Field("info") String info
                              )
            ;

    @FormUrlEncoded
    @POST("bonus/edit_company.php")
    Call<Otvet> updateCompany(
                              @Field("name") String name,
                              @Field("index") String index,
                              @Field("city") String city,
                              @Field("address") String address,
                              @Field("build") String build,
                              @Field("office") String office,
                              @Field("company_category") int company_category,
                              @Field("time_open") String time_open,
                              @Field("time_close") String time_close,
                              @Field("telephone") String telephone,
                              @Field("loyalty_id") String loyalty_id,
                              @Field("sale") String sale,
                              @Field("invite_price") String invite_price,
                              @Field("password") String password,
                              @Field("image") String image,
                              @Field("step1_col") String step1_col,
                              @Field("step2_col") String step2_col,
                              @Field("step3_col") String step3_col,
                              @Field("step4_col") String step4_col,
                              @Field("step1") String step1,
                              @Field("step2") String step2,
                              @Field("step3") String step3,
                              @Field("step4") String step4,
                              @Field("id_company") String id_company,
                              @Field("token") String token,
                              @Field("info") String info
    )
            ;


    @GET("bonus/login_company.php")
    Call<Otvet> login(@Query("login") String login,
                      @Query("password") String password);

    @FormUrlEncoded
    @POST("bonus/company_admin.php")
    Call<List<InfoCompany>> getInfoCompany(@Field("id_company") String id_company,
                                           @Field("token") String token);


    @FormUrlEncoded
    @POST("bonus/company_client_info.php")
    Call<List<UserInfo>> getUserInfo(@Field("id_user") String id_user,
                               @Field("id_company") String id_company,
                               @Field("token") String token
                            );

    @FormUrlEncoded
    @POST("bonus/add_news_company.php")
    Call<Otvet> addNews(@Field("time") String time,
                                     @Field("id_company") String id_company,
                                     @Field("title") String title,
                                     @Field("text") String text,
                                     @Field("image") String image
    );

    @FormUrlEncoded
    @POST("bonus/delete_news_company.php")
    Call<Otvet> deleteNews(@Field("news_id") String news_id
    );

    @FormUrlEncoded
    @POST("bonus/edit_news_company.php")
    Call<Otvet> updateNews(@Field("time") String time,
                        @Field("id_company") String id_company,
                        @Field("news_id") String news_id,
                        @Field("title") String title,
                        @Field("text") String text,
                        @Field("image") String image
    );
    @FormUrlEncoded
    @POST("bonus/qr_client.php")
    Call<List<QrExample>> getUsrtInfoQR(@Field("id_company") String id_company,
                                        @Field("token") String token,
                                        @Field("qr_client") String qr_client
    );

    @FormUrlEncoded
    @POST("bonus/qr_client.php")
    Call<Otvet> setBuy(@Field("id_company") String id_company,
                                  @Field("token") String token,
                                  @Field("qr_client") String qr_client,
                                  @Field("sale") String sale
    );

    @FormUrlEncoded
    @POST("bonus/qr_transaction.php")
    Call<Otvet> setBuyTransaktion(@Field("id_user") String id_user,
                       @Field("id_company") String id_company,
                       @Field("token") String token,
                       @Field("price") String price
    );

    @FormUrlEncoded
    @POST("bonus/forgot_password_company.php")
    Call<Otvet> sendEmail(@Field("email") String email);

    @FormUrlEncoded
    @POST("bonus/email_activate_news.php")
    Call<Otvet> sendAddNews(@Field("id_company") String id_company,
                            @Field("token") String token);

}

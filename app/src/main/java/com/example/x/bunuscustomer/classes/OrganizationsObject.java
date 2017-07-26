package com.example.x.bunuscustomer.classes;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by x on 17.06.2017.
 */

public class OrganizationsObject extends BaseObservable {

    private ObservableField<String> index;
    private ObservableField<String> city;
    private ObservableField<String> street;
    private ObservableField<String> home;
    private ObservableField<String> kv;
    private ObservableField<String> name;
    private ObservableField<String> time_from;
    private ObservableField<String> time_to;
    private ObservableField<String> email;
    private ObservableField<String> phone;
    private ObservableInt loyalty_id;
    private ObservableBoolean loyalty_is;
    private ObservableField<String> loyalty_text;
    private ObservableField<String> fixed_price;
    private ObservableBoolean isFriend;
    private ObservableField<String> friend_frice;
    private ObservableBoolean isImg;
    private ObservableField<Uri> bitmap;
    private ObservableField<String> image;
    private ObservableBoolean isOferta;

    private ObservableField<String> password1;
    private ObservableField<String> password2;
    private ObservableBoolean isPass;

    private ObservableField<String> buy1;
    private ObservableField<String> buy2;
    private ObservableField<String> buy3;
    private ObservableField<String> buy4;

    private ObservableField<String> proc1;
    private ObservableField<String> proc2;
    private ObservableField<String> proc3;
    private ObservableField<String> proc4;

    private ObservableField<String> unp;
    private ObservableField<String> date;

    private ObservableField<String> info;

    public OrganizationsObject(){
        index = new ObservableField<>("");
        city = new ObservableField<>("");
        street = new ObservableField<>("");
        home = new ObservableField<>("");
        kv = new ObservableField<>("");
        name = new ObservableField<>("");
        time_from = new ObservableField<>("");
        time_to = new ObservableField<>("");
        email = new ObservableField<>("");
        phone = new ObservableField<>("");
        loyalty_id = new ObservableInt(1);
        loyalty_is = new ObservableBoolean(true);
        loyalty_text = new ObservableField<>("Фиксированная");
        fixed_price = new ObservableField<>("");
        isFriend = new ObservableBoolean(false);
        friend_frice = new ObservableField<>();
        image = new ObservableField<>("");
        isImg = new ObservableBoolean(false);
        bitmap = new ObservableField<Uri>();
        isOferta = new ObservableBoolean(false);

        password1 = new ObservableField<>("");
        password2 = new ObservableField<>("");
        isPass = new ObservableBoolean(false);

        buy1 = new ObservableField<>("0");
        buy2 = new ObservableField<>("5");
        buy3 = new ObservableField<>("10");
        buy4 = new ObservableField<>("20");

        proc1 = new ObservableField<>("1");
        proc2 = new ObservableField<>("3");
        proc3 = new ObservableField<>("5");
        proc4 = new ObservableField<>("7");


        unp = new ObservableField<>("");
        date = new ObservableField<>("");

        info = new ObservableField<>();



    }

    public ObservableField<String> getIndex() {
        return index;
    }

    public void setIndex(ObservableField<String> pindex) {
        index.set(pindex.get());
    }

    public ObservableField<String> getCity() {
        return city;
    }

    public void setCity(ObservableField<String> pcity) {
        city.set(pcity.get());
    }

    public ObservableField<String> getStreet() {
        return street;
    }

    public void setStreet(ObservableField<String> pstreet) {
        street.set(pstreet.get());
    }

    public ObservableField<String> getHome() {
        return home;
    }

    public void setHome(ObservableField<String> phome) {
        home.set(phome.get());
    }

    public ObservableField<String> getKv() {
        return kv;
    }

    public void setKv(ObservableField<String> pkv) {
        kv.set(pkv.get());
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> pname) {
        name.set(pname.get());
    }

    public ObservableField<String> getTime_from() {
        return time_from;
    }

    public void setTime_from(ObservableField<String> ptime_from) {
        time_from.set(ptime_from.get());
    }

    public ObservableField<String> getTime_to() {
        return time_to;
    }

    public void setTime_to(ObservableField<String> ptime_to) {
        ptime_to.set(ptime_to.get());
    }

    public ObservableField<String> getEmail() {
        return email;
    }

    public void setEmail(ObservableField<String> pemail) {
        email.set(pemail.get());
    }

    public ObservableField<String> getPhone() {
        return phone;
    }

    public void setPhone(ObservableField<String> pphone) {
        phone.set(pphone.get());
    }


    public ObservableField<String> getImage() {
        return image;
    }

    public void setImage(ObservableField<String> pimage) {
        image.set(pimage.get());
    }

    public ObservableInt getLoyalty_id() {
        return loyalty_id;
    }

    public void setLoyalty_id(ObservableInt ployalty_id) {
        loyalty_id.set(ployalty_id.get());
    }

    public ObservableField<String> getLoyalty_text() {
        return loyalty_text;
    }

    public void setLoyalty_text(ObservableField<String> ployalty_text) {
        loyalty_text.set(ployalty_text.get());
    }

    public ObservableBoolean getLoyalty_is() {
        return loyalty_is;
    }

    public void setLoyalty_is(ObservableBoolean ployalty_is) {
        loyalty_is.set(ployalty_is.get());
    }

    public ObservableField<String> getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(ObservableField<String> pfixed_price) {
        fixed_price.set(pfixed_price.get());
    }

    public ObservableBoolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(ObservableBoolean pisFriend) {
        isFriend.set(pisFriend.get());
    }

    public ObservableBoolean getIsImg() {
        return isImg;
    }

    public void setIsImg(ObservableBoolean pisImg) {
        isImg.set(pisImg.get());
    }

    public ObservableField<Uri> getBitmap() {
        return bitmap;
    }

    public void setBitmap(ObservableField<Uri> pbitmap) {
        bitmap.set(pbitmap.get());
    }

    public ObservableBoolean getIsOferta() {
        return isOferta;
    }

    public void setIsOferta(ObservableBoolean pisOferta) {
        isOferta.set(pisOferta.get());
    }

    public ObservableField<String> getFriend_frice() {
        return friend_frice;
    }

    public void setFriend_frice(ObservableField<String> pfriend_frice) {
        friend_frice.set(pfriend_frice.get());
    }

    public ObservableField<String> getPassword1() {
        return password1;
    }

    public void setPassword1(ObservableField<String> ppassword1) {
        ppassword1.set(ppassword1.get());
    }

    public ObservableField<String> getPassword2() {
        return password2;
    }

    public void setPassword2(ObservableField<String> ppassword2) {
        password2.set(ppassword2.get());
    }

    public ObservableBoolean getIsPass() {
        if(password1.get().contains(password2.get())) isPass.set(true);
        else isPass.set(false);
        return isPass;
    }

    public void setIsPass(ObservableBoolean pisPass) {
        isPass.set(pisPass.get());
    }

    public ObservableField<String> getBuy1() {
        return buy1;
    }

    public void setBuy1(ObservableField<String> pbuy1) {
        buy1.set(pbuy1.get());
    }

    public ObservableField<String> getBuy2() {
        return buy2;
    }

    public void setBuy2(ObservableField<String> pbuy2) {
        buy2.set(pbuy2.get());
    }

    public ObservableField<String> getBuy3() {
        return buy3;
    }

    public void setBuy3(ObservableField<String> pbuy3) {
        buy3.set(pbuy3.get());
    }

    public ObservableField<String> getBuy4() {
        return buy4;
    }

    public void setBuy4(ObservableField<String> pbuy4) {
        buy4.set(pbuy4.get());
    }


    public ObservableField<String> getProc1() {
        return proc1;
    }

    public void setProc1(ObservableField<String> pproc1) {
        proc1.set(pproc1.get());
    }

    public ObservableField<String> getProc2() {
        return proc2;
    }

    public void setProc2(ObservableField<String> pproc2) {
        proc2.set(pproc2.get());
    }

    public ObservableField<String> getProc3() {
        return proc3;
    }

    public void setProc3(ObservableField<String> pproc3) {
        proc3.set(pproc3.get());
    }

    public ObservableField<String> getProc4() {
        return proc4;
    }

    public void setProc4(ObservableField<String> pproc4) {
        proc4.set(pproc4.get());
    }

    public ObservableField<String> getUnp() {
        return unp;
    }

    public void setUnp(ObservableField<String> punp) {
        unp.set(punp.get());
    }

    public ObservableField<String> getDate() {
        return date;
    }

    public void setDate(ObservableField<String> pdate) {
        date.set(pdate.get());
    }

    public ObservableField<String> getInfo() {
        return info;
    }

    public void setInfo(ObservableField<String> pinfo) {
        info.set(pinfo.get());
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
       String s1 = "";
    }

}

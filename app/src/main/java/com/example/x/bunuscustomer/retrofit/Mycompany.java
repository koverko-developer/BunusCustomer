package com.example.x.bunuscustomer.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobi app on 01.07.2017.
 */

public class Mycompany {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("unp")
    @Expose
    private String unp;
    @SerializedName("rekvizity")
    @Expose
    private String rekvizity;
    @SerializedName("diretor")
    @Expose
    private Object diretor;
    @SerializedName("osnovanie")
    @Expose
    private String osnovanie;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("loyalty_id")
    @Expose
    private String loyaltyId;
    @SerializedName("sale")
    @Expose
    private String sale;
    @SerializedName("map")
    @Expose
    private String map;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("invite_price")
    @Expose
    private String invitePrice;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("category_id")
    @Expose
    private CategoryId categoryId;
    @SerializedName("loyalty_step")
    @Expose
    private LoyaltyStep loyaltyStep;
    @SerializedName("news")
    @Expose
    private List<News> news = null;
    @SerializedName("company_user")
    @Expose
    private List<CompanyUser> companyUser = null;

    @SerializedName("status_news")
    @Expose
    private String statusNews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnp() {
        return unp;
    }

    public void setUnp(String unp) {
        this.unp = unp;
    }

    public String getRekvizity() {
        return rekvizity;
    }

    public void setRekvizity(String rekvizity) {
        this.rekvizity = rekvizity;
    }

    public Object getDiretor() {
        return diretor;
    }

    public void setDiretor(Object diretor) {
        this.diretor = diretor;
    }

    public String getOsnovanie() {
        return osnovanie;
    }

    public void setOsnovanie(String osnovanie) {
        this.osnovanie = osnovanie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLoyaltyId() {
        return loyaltyId;
    }

    public void setLoyaltyId(String loyaltyId) {
        this.loyaltyId = loyaltyId;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInvitePrice() {
        return invitePrice;
    }

    public void setInvitePrice(String invitePrice) {
        this.invitePrice = invitePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryId categoryId) {
        this.categoryId = categoryId;
    }

    public LoyaltyStep getLoyaltyStep() {
        return loyaltyStep;
    }

    public void setLoyaltyStep(LoyaltyStep loyaltyStep) {
        this.loyaltyStep = loyaltyStep;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<CompanyUser> getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(List<CompanyUser> companyUser) {
        this.companyUser = companyUser;
    }

    public String getStatusNews() {
        return statusNews;
    }

    public void setStatusNews(String statusNews) {
        this.statusNews = statusNews;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
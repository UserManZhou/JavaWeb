package com.gec.web.model;

public class UserImg {

    private int user_id;
    private String img_url;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "UserImg{" +
                "user_id=" + user_id +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public UserImg(int user_id, String img_url) {
        this.user_id = user_id;
        this.img_url = img_url;
    }

    public UserImg() {
    }
}

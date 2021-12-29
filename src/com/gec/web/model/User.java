package com.gec.web.model;

import java.util.Date;

public class User extends UserImg{

    private int id;
    private String username;
    private String password;
    private Date create_date;
    private Date update_date;
    private String accement_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getAccement_name() {
        return accement_name;
    }

    public void setAccement_name(String accement_name) {
        this.accement_name = accement_name;
    }

    public User(int id, String username, String password, Date create_date, Date update_date, String accement_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.create_date = create_date;
        this.update_date = update_date;
        this.accement_name = accement_name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", accement_name='" + accement_name + '\'' +
                '}';
    }
}

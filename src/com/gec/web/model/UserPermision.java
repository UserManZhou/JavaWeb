package com.gec.web.model;

public class UserPermision {

    private int user_id;
    private int permision_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPermision_id() {
        return permision_id;
    }

    public void setPermision_id(int permision_id) {
        this.permision_id = permision_id;
    }

    public UserPermision(int user_id, int permision_id) {
        this.user_id = user_id;
        this.permision_id = permision_id;
    }

    public UserPermision() {
    }

    @Override
    public String toString() {
        return "UserPermision{" +
                "user_id=" + user_id +
                ", permision_id=" + permision_id +
                '}';
    }
}

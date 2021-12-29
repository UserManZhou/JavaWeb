package com.gec.web.model.service;

import com.gec.web.model.UserImg;

import java.sql.SQLException;

public interface UserImgService {

    public void insertUserAndImg(UserImg userImg) throws SQLException;

}

package com.gec.web.model.service;

import com.gec.web.model.User;

import java.sql.SQLException;

public interface UserService {

    public void inserUser(User user) throws SQLException;

    public int lastInsertUser() throws SQLException;
}

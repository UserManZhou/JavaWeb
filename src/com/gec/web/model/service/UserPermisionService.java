package com.gec.web.model.service;

import com.gec.web.model.UserPermision;

import java.sql.SQLException;

public interface UserPermisionService {

    public void insertUserAndPermision(UserPermision userPermision) throws SQLException;

}

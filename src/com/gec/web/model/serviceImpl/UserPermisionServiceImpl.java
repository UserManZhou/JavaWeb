package com.gec.web.model.serviceImpl;

import com.gec.web.model.UserPermision;
import com.gec.web.model.service.UserPermisionService;
import com.gec.web.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserPermisionServiceImpl implements UserPermisionService {
    @Override
    public void insertUserAndPermision(UserPermision userPermision) throws SQLException {
        String sql = "INSERT INTO `user_permision`(`user_id`) VALUE (?)";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userPermision.getUser_id());
        preparedStatement.executeUpdate();
        JDBCUtil.close(connection,preparedStatement,null);
    }
}

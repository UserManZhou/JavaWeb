package com.gec.web.model.serviceImpl;

import com.gec.web.model.User;
import com.gec.web.model.service.UserService;
import com.gec.web.utils.JDBCUtil;
import com.gec.web.utils.PathUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImpl implements UserService {
    @Override
    public void inserUser(User user) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String sql = "INSERT INTO `user`(`username`,`password`,`create_date`,`accement_num`) VALUES(?,?,?,?)";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        Timestamp timestamp = new Timestamp(user.getCreate_date().getTime());
        preparedStatement.setTimestamp(3,timestamp);
        preparedStatement.setString(4,user.getAccement_name());
        preparedStatement.executeUpdate();
        JDBCUtil.close(connection,preparedStatement,null);
    }

    @Override
    public int lastInsertUser() throws SQLException {
        String sql = "SELECT MAX(`user`.`id`) AS id FROM `user`";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        int i = 0;
        while (resultSet.next()){
            i = resultSet.getInt("id");
        }
        JDBCUtil.close(connection,preparedStatement,resultSet);
        return i;
    }
}

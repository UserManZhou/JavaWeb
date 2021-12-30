package com.gec.web.model.serviceImpl;

import com.gec.web.model.User;
import com.gec.web.model.UserImg;
import com.gec.web.model.service.UserImgService;
import com.gec.web.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImgServiceImpl implements UserImgService {

    @Override
    public void insertUserAndImg(UserImg userImg) throws SQLException {
        String sql = "INSERT INTO `user_img`(`img_url`,`user_id`) VALUES (?,?)";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userImg.getImg_url());
        preparedStatement.setInt(2,userImg.getUser_id());
        preparedStatement.executeUpdate();
        JDBCUtil.close(connection,preparedStatement,null);
    }

    @Override
    public UserImg searchByUserImg(UserImg userImg) throws SQLException {
        String sql = "SELECT * FROM `user_img` WHERE `user_id` = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userImg.getUser_id());
        ResultSet resultSet = preparedStatement.executeQuery();
        UserImg userImgs = new UserImg();
        while (resultSet.next()){
            userImgs.setImg_url(resultSet.getString("img_url"));
        }
        return userImgs;
    }
}

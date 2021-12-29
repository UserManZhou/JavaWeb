package com.gec.web.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class JDBCUtil {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream resource = JDBCUtil.class.getResourceAsStream("/JDBC.properties");
            properties.load(resource);
            Class.forName(properties.getProperty("driverClassName"));
//            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

   public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
      try {
          connection.close();
          preparedStatement.close();
          if (resultSet != null) resultSet.close();
      }catch (Exception e){
          System.out.println(e.getMessage());
      };
    }

}

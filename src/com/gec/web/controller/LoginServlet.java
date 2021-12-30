package com.gec.web.controller;

import com.gec.web.model.User;
import com.gec.web.model.UserImg;
import com.gec.web.model.service.UserImgService;
import com.gec.web.model.service.UserService;
import com.gec.web.model.serviceImpl.UserImgServiceImpl;
import com.gec.web.model.serviceImpl.UserServiceImpl;
import com.gec.web.utils.Base64Util;
import com.gec.web.utils.PathUtil;
import sun.security.provider.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login","/loginUser"})
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private UserImgService userImgService = new UserImgServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.getPath(req.getRequestURI());
        switch (path){
            case "login":
                if (req.getAttribute("messages") != null){
                    req.setAttribute("message",req.getAttribute("messages"));
                    req.getRequestDispatcher(PathUtil.SUB+"Login.jsp").forward(req,resp);
                }else {
                    req.getRequestDispatcher(PathUtil.SUB+"Login.jsp").forward(req,resp);
                }
                break;
            case "loginUser":
                User user = new User(0,null, Base64Util.base64EncodePassword(req.getParameter("password")),null,null,req.getParameter("accement_name"));
                User userByPassword = new User();
                try {
                     userByPassword = userService.findUserByPassword(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (userByPassword.getId() == 0) {
//                    req.getRequestDispatcher(PathUtil.SUB+"Login"+PathUtil.PRE).forward(req,resp);
//                    resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//                    resp.setHeader("Location",req.getServletContext().getContextPath()+"/login");
//                    resp.sendRedirect(PathUtil.SUB+"Login"+PathUtil.PRE);
                    req.setAttribute("messages","用户或密码错误");
                    req.getRequestDispatcher("/login").forward(req,resp);
                }else if(userByPassword.getId() != 0){
                    UserImg userImg = new UserImg();
                    try {
                       userImg =  userImgService.searchByUserImg(new UserImg(userByPassword.getId(),null));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    System.out.println(userImg.toString());
                    HttpSession session = req.getSession();
                    session.setAttribute("img_url",userImg.getImg_url());
                    session.setAttribute("username",userByPassword.getUsername());
                    req.getRequestDispatcher("/home").forward(req,resp);
                }
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}

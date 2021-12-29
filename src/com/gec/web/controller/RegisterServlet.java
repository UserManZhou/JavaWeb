package com.gec.web.controller;

import com.gec.web.model.User;
import com.gec.web.model.UserImg;
import com.gec.web.model.UserPermision;
import com.gec.web.model.service.UserImgService;
import com.gec.web.model.service.UserPermisionService;
import com.gec.web.model.service.UserService;
import com.gec.web.model.serviceImpl.UserImgServiceImpl;
import com.gec.web.model.serviceImpl.UserPermisionServiceImpl;
import com.gec.web.model.serviceImpl.UserServiceImpl;
import com.gec.web.utils.Base64Util;
import com.gec.web.utils.PathUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(urlPatterns = {"/register","/updateImg","/register_user"})
@MultipartConfig()
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    private UserImgService userImgService = new UserImgServiceImpl();
    private UserPermisionService userPermisionService = new UserPermisionServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.getPath(req.getRequestURI());
        switch (path){
            case "register":
                req.getRequestDispatcher(PathUtil.SUB+"/register/Register"+PathUtil.PRE).forward(req,resp);
                break;
            case "updateImg":
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                diskFileItemFactory.setRepository(new File("F:\\"));
                diskFileItemFactory.setSizeThreshold(1024 * 1024 * 100);

                ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
                upload.setHeaderEncoding("UTF-8");
                upload.setFileSizeMax(1024 * 1024 * 100);
                upload.setSizeMax(1024 * 1024 * 100);

               String url =  PathUtil.PATHURL+File.separator+"user_img";
               File file = new File(url);

                if (!file.exists()) file.mkdir();

                try {
                   @SuppressWarnings("unchecked")
                    List<FileItem> fileItems = upload.parseRequest(req);
                    for (FileItem item : fileItems) {
                        File files = new File(file.getPath(),item.getName());
                        item.write(files);
                        req.setAttribute("img",item.getName());
                    }
                    req.getRequestDispatcher(PathUtil.SUB+"register/Register"+PathUtil.PRE).forward(req,resp);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case "register_user" :
                User user = new User();
                UserImg userImg = new UserImg();
                UserPermision userPermision = new UserPermision();
                Map<String, String[]> parameterMap = req.getParameterMap();
                Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
                Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String[]> next = iterator.next();
                    if (next.getKey().equals("img_url")) user.setImg_url(req.getParameter(next.getKey()));
                    else if (next.getKey().equals("username")) user.setUsername(req.getParameter(next.getKey()));
                    else if (next.getKey().equals("password"))  user.setPassword(Base64Util.base64EncodePassword(req.getParameter(next.getKey())));
                    else if (next.getKey().equals("accement_name")) user.setAccement_name(req.getParameter(next.getKey()));
                }
                user.setCreate_date(new Date());
                userImg.setImg_url(user.getImg_url());
                try {
                    service.inserUser(user);
                    int id = service.lastInsertUser();
                    userImg.setUser_id(id);
                    userPermision.setUser_id(id);
                    userImgService.insertUserAndImg(userImg);
                    userPermisionService.insertUserAndPermision(userPermision);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher(PathUtil.SUB+"Login"+PathUtil.PRE).forward(req,resp);
            default:
                System.out.println("default");
                break;
        }
    }
}

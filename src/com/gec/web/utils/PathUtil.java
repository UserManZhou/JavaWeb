package com.gec.web.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;

public class PathUtil {

    public static final String SUB = "/WEB-INF/jsp/";
    public static final  String PRE = ".jsp";
    public static final String PATHURL = "F:\\JavaCode\\IDEA_JavaWeb\\JavaWebed\\web";

    public static String getPath(String requestPath){
        String url = (String) requestPath.substring(requestPath.lastIndexOf("/")+1,requestPath.length());
        return  url;
    }

}

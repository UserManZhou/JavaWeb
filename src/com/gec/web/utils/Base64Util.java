package com.gec.web.utils;

import sun.misc.BASE64Encoder;

public class Base64Util {

    public static String base64EncodePassword(String password){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        password =  password+"!@#$%^&*()";
        return base64Encoder.encode(password.getBytes());
    }

}

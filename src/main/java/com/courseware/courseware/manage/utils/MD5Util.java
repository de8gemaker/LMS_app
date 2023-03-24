package com.courseware.courseware.manage.utils;

import org.springframework.util.Base64Utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 */
public class MD5Util {
    public final static String md5(String str) {
        MessageDigest messageDigest = null;
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(str.getBytes());
        return Base64Utils.encodeToString(messageDigest.digest());
    }
    public final static String sha_1(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(str.getBytes());
        return Base64Utils.encodeToString(messageDigest.digest());
    }
    public final static String encode(String str) {
        return md5(sha_1(md5(str)));
    }
}

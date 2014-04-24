package com.pubiapplication.app;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

/**
 * Created by indrek on 24.04.14.
 */
public class stringToHash {


    public static String giveMeHash(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }

}

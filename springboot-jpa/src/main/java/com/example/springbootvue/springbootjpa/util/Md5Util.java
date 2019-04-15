package com.example.springbootvue.springbootjpa.util;

import java.security.MessageDigest;

/**
 * @program: springboot-vue
 * @descripttion: md5
 * @author: jiuson
 * @create: 2019-03-29 14:35:26
 */
public class Md5Util {

    public static String MD5(String plaintext) {
        String result = "";
        String str = plaintext;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((str).getBytes("UTF-8"));
            byte b[] = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer("");

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            result = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

package com.soft1851.springboot.jwt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jack
 * @Date: 2020/4/15 10:51
 * @Description:
 */
public class Md5Util {

    public static String getMd5(String buffer)
    {
        String string = null;
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(buffer.getBytes());
            //16个字节的长整数
            byte[] date = md.digest();
            char[] str = new char[2*16];
            int k = 0;
            for(int i=0;i<16;i++)
            {
                byte b   = date[i];
                //高4位
                str[k++] = hexDigits[b>>>4 & 0xf];
                //低4位
                str[k++] = hexDigits[b & 0xf];
            }
            string = new String(str);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return string;
    }


}

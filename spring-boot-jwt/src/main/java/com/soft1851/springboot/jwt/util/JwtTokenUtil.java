package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

/**
 * @author Jack
 * @Date: 2020/4/15 16:58
 * @Description:
 */
@Slf4j
public class JwtTokenUtil {
    private static String salt;

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        // 生成token
        String token = JwtTokenUtil.getToken("admin", "soft1851", "软件1851");
        String salt = JwtTokenUtil.getSalt();
        // 打印token
        System.out.println(salt);
        System.out.println("token: " + token);
        System.out.println("------------------------------------");
        // 解密token
        DecodedJWT jwt = JwtTokenUtil.deToken(token,salt);
        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("userRole:  " + jwt.getClaim("userRole").asString());
        System.out.println("username: " + jwt.getClaim("username").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("过期时间：" +jwt.getExpiresAt());
        for(int i=0;i<10;i++) {
            try {
                System.out.println(isExpiration(token));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                log.info("空指针");
            }
        }

//        if(test){
//            System.out.println("已经过期了");
//        }
    }

    /**
     * 生成加密后的token
     * @param userRole
     * @param username
     * @param name
     * @return
     */
    public static String getToken(final String userRole, final String username,final String name) {
        String token = null;
        //获取随机盐，并保存到本类属性中
        salt = JwtTokenUtil.getSalt("hanyuan");
        //根据盐，生成md5和sha256加密后的私钥
        String myselect = JwtTokenUtil.getPrivate(JwtTokenUtil.getSHA256Encryption(JwtTokenUtil.getMd5Encryption(salt)));
        //设置token的有效时间
        Date expiresAt = new Date(System.currentTimeMillis() + 3L * 1000L);
        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userRole", userRole)
                    .withClaim("username", username)
                    .withClaim("name", name)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥。
                    .sign(Algorithm.HMAC256(myselect));
        } catch (Exception e){
            log.info("加密出现错误");
        }

        return token;
    }

    /**
     * 根据用户的账号，进行md5和sha256加密，生成私钥，再通过私钥解密token
     * @param token
     * @param salt
     * @return
     */
    public static DecodedJWT deToken(final String token, String salt) {
        String mySecret = JwtTokenUtil.getPrivate(JwtTokenUtil.getSHA256Encryption(JwtTokenUtil.getMd5Encryption(salt)));
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(mySecret))
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (Exception e){
            log.info("解密出现问题");
        }
        return jwt;
    }

    /**
     * 获取用户角色
     * @param token
     * @return
     */
    public static String getUserRole(String token){
        return deToken(token, JwtTokenUtil.getSalt()).getClaim("userRole").asString();
    }

    /**
     * 获取用户账号
     * @param token
     * @return
     */
    public static String getUserName(String token) {
        return deToken(token, JwtTokenUtil.getSalt()).getClaim("username").asString();
    }

    /**
     * 验证token是否过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        Boolean judge = deToken(token, JwtTokenUtil.getSalt()).getExpiresAt().before(new Date());
        return  judge;
    }

    /**
     * 根据账号生成随机盐，后续存入数据库
     * @param content
     * @return
     */
    public  static String getSalt(String content){
        //生成两个随机数
        int num1 = new Random().nextInt(999999999);
        int num2 = new Random().nextInt(999999999);
        String salt = String.valueOf(num1)+String.valueOf(num2)+content;
        if(salt.length()<16){
            for(int i=0;i<16-salt.length();i++){
                salt += "0";
            }
        }
        return salt;
    }

    /**
     * 生成md5加密后的字符串
     * @return
     */
    public static String getMd5Encryption(String content){
        return Md5Util.getMd5(content);
    }

    /**
     * 根据md5加密后的字符串，进行字节转换
     * @param content
     * @return
     */
    public static String getSHA256Encryption(String content){
        byte[] bytes = content.getBytes();
        return Sha256Util.getSha256(Sha256Util.byte2Hex(bytes));
    }

    /**
     * 根据转换后的字节，进行sha256加密
     * @param account
     * @return
     */
    public static String getPrivate(String account){
        return JwtTokenUtil.getSHA256Encryption(JwtTokenUtil.getMd5Encryption(account));
    }

    public static String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

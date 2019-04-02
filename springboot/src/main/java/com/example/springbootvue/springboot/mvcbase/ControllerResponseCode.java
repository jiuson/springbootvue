package com.example.springbootvue.springboot.mvcbase;

/**
 * @program: springboot-vue
 * @descripttion: general controller response code
 * @author: jiuson
 * @create: 2019-03-29 14:23:24
 */
public class ControllerResponseCode {

    /**新用户注册相关*/
    public static int REGISTER_VERIFY_USERNAME_REPEAT_CODE = -100;
    public static String REGISTER_VERIFY_USERNAME_REPEAT_MESSAGE = "用户名已存在，请重新设置用户名";

    /**用户登录相关*/
    public static int LOGIN_VERIFY_USERNAME_ERROR_CODE = -101;
    public static String LOGIN_VERIFY_USERNAME_ERROR_MSG = "用户名有误，请检查";

    public static int LOGIN_VERIFY_PASSWORD_ERROR_CODE = -102;
    public static String LOGIN_VERIFY_PASSWORD_ERROR_MSG = "密码有误，请检查";

    public static int LOGIN_VERIFY_USERNAME_NO_ERROR_CODE = -103;
    public static String LOGIN_VERIFY_USERNAME_NO_ERROR_MESSAGE = "用户不存在，请检查";

}

package com.aries.smart.constant;

/**
 * @Author: AriesHoo on 2018/11/19 14:14
 * @E-Mail: AriesHoo@126.com
 * @Function: 接口地址常量
 * @Description:
 */
public class ApiConstant {

    /* /hamster-user/sms type */
    public static final String SMS_TYPE_Login= "2"; //登录
    public static final String SMS_TYPE_REGISTER= "3"; //注册

    /* path */
    public static final String API_USER_SMS_SEND_CODE = "/hamster-user/sms/sendCode"; //发送短信验证码
    public static final String API_USER_SMS_VERIFICATION_CODE = "/hamster-user/sms/verificationCode"; //发送短信验证码
    public static final String API_USER_ACCOUNT_CREATE = "/hamster-user/user/accountCreate"; //创建账号

}

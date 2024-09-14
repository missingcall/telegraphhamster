package com.aries.smart.retrofit.service;

import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.request.AccountCreateTo;
import com.aries.smart.retrofit.response.AccountCreateResponse;
import com.aries.smart.retrofit.response.SmsSendResponse;
import com.aries.smart.retrofit.response.SmsVerificationResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthService {




    /**
     *
     * @param mobile
     * @param type 类型：2-登录 3-注册 4-注销 5-找回密码 6-绑定手机号码 7-设置二级密码 8-绑定银行卡 9-找回账号 11-验证旧手机 12-快捷认证 13-人工认证 14-转账认证 15-绑定支付宝
     * @return
     */
    @GET(ApiConstant.API_USER_SMS_SEND_CODE)
    Observable<SmsSendResponse> smsSendCode(@Query("mobile") String mobile, @Query("type") String type);


    /**
     * @param code 验证码
     * @param mobile 手机号
     * @param type 类型：2-登录 3-注册 4-注销 5-找回密码 6-绑定手机号码 7-设置二级密码 8-绑定银行卡 9-找回账号 11-验证旧手机 12-快捷认证 13-人工认证 14-转账认证 15-绑定支付宝
     * @return
     */
    @GET(ApiConstant.API_USER_SMS_VERIFICATION_CODE)
    Observable<SmsVerificationResponse> smsVerification(@Query("code") String code, @Query("mobile") String mobile, @Query("type") String type);

    /**
     * @param
     * @param
     * @param
     * @return
     */
    @POST(ApiConstant.API_USER_ACCOUNT_CREATE)
    Observable<AccountCreateResponse> accountCreate(@Body AccountCreateTo accountCreateTo);
}

package com.aries.smart.retrofit.service;

import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.request.AccountCreateTo;
import com.aries.smart.retrofit.request.ActivationPropIdTo;
import com.aries.smart.retrofit.request.LoginTo;
import com.aries.smart.retrofit.request.MarketBuyTo;
import com.aries.smart.retrofit.request.PasswordLoginTo;
import com.aries.smart.retrofit.request.ResetUserLoginPasswordTo;
import com.aries.smart.retrofit.request.UpdateNicknameTo;
import com.aries.smart.retrofit.response.AccountCreateResponse;
import com.aries.smart.retrofit.response.BaseResponse;
import com.aries.smart.retrofit.response.CheckFirstUpdateNicknameResponse;
import com.aries.smart.retrofit.response.GetLevelRankResponse;
import com.aries.smart.retrofit.response.GetLevelResponse;
import com.aries.smart.retrofit.response.GetMyMoneyBagResponse;
import com.aries.smart.retrofit.response.InfoResponse;
import com.aries.smart.retrofit.response.LoginResponse;
import com.aries.smart.retrofit.response.PasswordLoginResponse;
import com.aries.smart.retrofit.response.QueryDayIncomeResponse;
import com.aries.smart.retrofit.response.QueryMarketListResponse;
import com.aries.smart.retrofit.response.QueryPhoneExistResponse;
import com.aries.smart.retrofit.response.ResetUserLoginPasswordResponse;
import com.aries.smart.retrofit.response.SelectTaskInfoListResponse;
import com.aries.smart.retrofit.response.SmsSendResponse;
import com.aries.smart.retrofit.response.UpdateNicknameResponse;
import com.aries.smart.retrofit.response.VerificationCodeResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthService {


    /**
     *发送验证码
     * @param mobile
     * @param type 类型：2-登录 3-注册 4-注销 5-找回密码 6-绑定手机号码 7-设置二级密码 8-绑定银行卡 9-找回账号 11-验证旧手机 12-快捷认证 13-人工认证 14-转账认证 15-绑定支付宝
     * @return
     */
    @GET(ApiConstant.API_USER_SMS_SEND_CODE)
    Observable<SmsSendResponse> smsSendCode(@Query("mobile") String mobile, @Query("type") String type);


    /**
     * 短信验证
     * @param code 验证码
     * @param mobile 手机号
     * @param type 类型：2-登录 3-注册 4-注销 5-找回密码 6-绑定手机号码 7-设置二级密码 8-绑定银行卡 9-找回账号 11-验证旧手机 12-快捷认证 13-人工认证 14-转账认证 15-绑定支付宝
     * @return
     */
    @GET(ApiConstant.API_USER_SMS_VERIFICATION_CODE)
    Observable<VerificationCodeResponse> verificationCode(@Query("code") String code, @Query("mobile") String mobile, @Query("type") String type);

    /**
     * 创建账号
     * @param
     * @return
     */
    @POST(ApiConstant.API_USER_ACCOUNT_CREATE)
    Observable<AccountCreateResponse> accountCreate(@Body AccountCreateTo accountCreateTo);

    /**
     * 密码登录
     * @param
     * @return
     */
    @POST(ApiConstant.API_USER_PASSWORD_LOGIN)
    Observable<PasswordLoginResponse> passwordLogin(@Body PasswordLoginTo passwordLoginTo);

    /**
     * 查询号码是否存在
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_QUERY_PHONE_EXIST)
    Observable<QueryPhoneExistResponse> queryPhoneExist(@Query("phone") String phone);

    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_USER_RESET_USER_LOGIN_PASSWORD)
    Observable<ResetUserLoginPasswordResponse> resetUserLoginPassword(@Body ResetUserLoginPasswordTo queryPhoneExistTo);

    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_LOGIN)
    Observable<LoginResponse> login(@Body LoginTo loginTo);

    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_INFO)
    Observable<InfoResponse> info();

    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_USER_UPDATE_NICKNAME)
    Observable<UpdateNicknameResponse> updateNickname(@Body UpdateNicknameTo updateNicknameTo);

    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_GET_MY_MONEY_BAG)
    Observable<GetMyMoneyBagResponse> getMyMoneyBag();


    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_CHECK_FIRST_UPDATE_NICKNAME)
    Observable<CheckFirstUpdateNicknameResponse> checkFirstUpdateNickname();


    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_CENTER_QUERY_DAY_INCOME)
    Observable<QueryDayIncomeResponse> queryDayIncome();

    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_GET_LEVEL)
    Observable<GetLevelResponse> getLevel();

    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_USER_GET_LEVEL_RANK)
    Observable<GetLevelRankResponse> getLevelRank();

    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_TASK_SELECT_TASK_INFO_LIST)
    Observable<SelectTaskInfoListResponse> selectTaskInfoList();


    /**
     *
     * @param
     * @return
     */
    @GET(ApiConstant.API_CENTER_QUERY_MARKET_LIST)
    Observable<QueryMarketListResponse> queryMarketList(@Query("type") String type);


    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_CENTER_MARKET_ACTIVATION)
    Observable<BaseResponse> activation(@Body ActivationPropIdTo activationPropIdTo);


    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_CENTER_MARKET_BUY)
    Observable<BaseResponse> buy(@Body MarketBuyTo marketBuyTo);


}

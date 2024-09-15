package com.aries.smart.retrofit.repository;


import com.aries.library.fast.retrofit.FastRetrofit;
import com.aries.library.fast.retrofit.FastRetryWhen;
import com.aries.library.fast.retrofit.FastTransformer;
import com.aries.smart.retrofit.request.AccountCreateTo;
import com.aries.smart.retrofit.request.LoginTo;
import com.aries.smart.retrofit.request.PasswordLoginTo;
import com.aries.smart.retrofit.request.ResetUserLoginPasswordTo;
import com.aries.smart.retrofit.response.AccountCreateResponse;
import com.aries.smart.retrofit.response.LoginResponse;
import com.aries.smart.retrofit.response.PasswordLoginResponse;
import com.aries.smart.retrofit.response.QueryPhoneExistResponse;
import com.aries.smart.retrofit.response.ResetUserLoginPasswordResponse;
import com.aries.smart.retrofit.response.SmsSendResponse;
import com.aries.smart.retrofit.response.VerificationCodeResponse;
import com.aries.smart.retrofit.service.AuthService;

import io.reactivex.Observable;

/**
 * @Author: AriesHoo on 2018/11/19 14:25
 * @E-Mail: AriesHoo@126.com
 * @Function: Auth 登录注册
 * @Description:
 */
public class AuthRepository extends BaseRepository {

    /*  TO常量  */


    /*  Response常量  */

    private static volatile AuthRepository instance;
    private AuthService mAuthService;

    private AuthRepository() {
        mAuthService = getAuthService();
    }

    public static AuthRepository getInstance() {
        if (instance == null) {
            synchronized (AuthRepository.class) {
                if (instance == null) {
                    instance = new AuthRepository();
                }
            }
        }
        return instance;
    }

    private AuthService getAuthService() {
        mAuthService = FastRetrofit.getInstance().createService(AuthService.class);
        return mAuthService;
    }

    /**
     * 发送短信验证码
     *
     * @return
     */
    public Observable<SmsSendResponse> smsSendCode(String mobile, String type) {

        return FastTransformer.switchSchedulers(getAuthService().smsSendCode(mobile, type).retryWhen(new FastRetryWhen()));
    }

    /**
     * 短信验证码校验
     *
     * @return
     */
    public Observable<VerificationCodeResponse> verificationCode(String code, String mobile, String type) {

        return FastTransformer.switchSchedulers(getAuthService().verificationCode(code, mobile, type).retryWhen(new FastRetryWhen()));
    }


    public static final String TO_ACCOUNT_CREATE_ACCESS_FLAGS_ANDROID = "0";

    /**
     * 创建账号
     *
     * @return
     */
    public Observable<AccountCreateResponse> accountCreate(AccountCreateTo accountCreateTo) {

        return FastTransformer.switchSchedulers(getAuthService().accountCreate(accountCreateTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 密码登录
     *
     * @return
     */
    public Observable<PasswordLoginResponse> passwordLogin(PasswordLoginTo passwordLoginTo) {

        return FastTransformer.switchSchedulers(getAuthService().passwordLogin(passwordLoginTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 查询用户是否存在
     *
     * @return
     */
    public Observable<QueryPhoneExistResponse> queryPhoneExist(String phone) {

        return FastTransformer.switchSchedulers(getAuthService().queryPhoneExist(phone).retryWhen(new FastRetryWhen()));
    }

    /**
     * 忘记用户登录密码
     *
     * @return
     */
    public Observable<ResetUserLoginPasswordResponse> resetUserLoginPassword(ResetUserLoginPasswordTo resetUserLoginPasswordTo) {

        return FastTransformer.switchSchedulers(getAuthService().resetUserLoginPassword(resetUserLoginPasswordTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 手机号验证码登录(老版本)
     *
     * @return
     */
    public Observable<LoginResponse> login(LoginTo loginTo) {

        return FastTransformer.switchSchedulers(getAuthService().login(loginTo).retryWhen(new FastRetryWhen()));
    }

}

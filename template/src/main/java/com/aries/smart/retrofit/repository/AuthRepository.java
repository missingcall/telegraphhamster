package com.aries.smart.retrofit.repository;


import com.aries.library.fast.retrofit.FastRetrofit;
import com.aries.library.fast.retrofit.FastRetryWhen;
import com.aries.library.fast.retrofit.FastTransformer;
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
import com.aries.smart.retrofit.response.QueryWaitPineconeResponse;
import com.aries.smart.retrofit.response.ResetUserLoginPasswordResponse;
import com.aries.smart.retrofit.response.SelectTaskInfoListResponse;
import com.aries.smart.retrofit.response.SmsSendResponse;
import com.aries.smart.retrofit.response.UpdateMobileResponse;
import com.aries.smart.retrofit.response.UpdateNicknameResponse;
import com.aries.smart.retrofit.response.VerificationCodeResponse;
import com.aries.smart.retrofit.service.AuthService;

import io.reactivex.Completable;
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

    /**
     * 获取会员信息 /hamster-user/user/info
     *
     * @return
     */
    public Observable<InfoResponse> info() {

        return FastTransformer.switchSchedulers(getAuthService().info().retryWhen(new FastRetryWhen()));
    }

    /**
     * 修改昵称
     *
     * @return
     */
    public Observable<UpdateNicknameResponse> updateNickname(UpdateNicknameTo updateNicknameTo) {

        return FastTransformer.switchSchedulers(getAuthService().updateNickname(updateNicknameTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 我的钱包
     *
     * @return
     */
    public Observable<GetMyMoneyBagResponse> getMyMoneyBag() {

        return FastTransformer.switchSchedulers(getAuthService().getMyMoneyBag().retryWhen(new FastRetryWhen()));
    }

    /**
     * 验证是否首次修改昵称
     *
     * @return
     */
    public Observable<CheckFirstUpdateNicknameResponse> checkFirstUpdateNickname() {

        return FastTransformer.switchSchedulers(getAuthService().checkFirstUpdateNickname().retryWhen(new FastRetryWhen()));
    }

    /**
     * 获取用户当前每日可获得松果
     *
     * @return
     */
    public Observable<QueryDayIncomeResponse> queryDayIncome() {

        return FastTransformer.switchSchedulers(getAuthService().queryDayIncome().retryWhen(new FastRetryWhen()));
    }

    /**
     * 获取用户当前等级
     *
     * @return
     */
    public Observable<GetLevelResponse> getLevel() {

        return FastTransformer.switchSchedulers(getAuthService().getLevel().retryWhen(new FastRetryWhen()));
    }


    /**
     * 获取用户当前排行
     *
     * @return
     */
    public Observable<GetLevelRankResponse> getLevelRank() {

        return FastTransformer.switchSchedulers(getAuthService().getLevelRank().retryWhen(new FastRetryWhen()));
    }

    /**
     * 获取任务列表
       /hamster-task/taskInfo/selectTaskInfoList
     * @return
     */
    public Observable<SelectTaskInfoListResponse> selectTaskInfoList() {

        return FastTransformer.switchSchedulers(getAuthService().selectTaskInfoList().retryWhen(new FastRetryWhen()));
    }

    /**
     * 获取领养仓鼠&仓鼠果园-松果银行列表 商品类型(001-基础仓鼠&仓鼠庄园,003-仓鼠银行)
     /hamster-task/taskInfo/queryMarketList
     * @return
     */
    public Observable<QueryMarketListResponse> queryMarketList(String type) {

        return FastTransformer.switchSchedulers(getAuthService().queryMarketList(type).retryWhen(new FastRetryWhen()));
    }

    /**
     * 背包物品激活
     *
     * /hamster-center/hamsterMarket/activation
     * @return
     */
    public Observable<BaseResponse> activation(ActivationPropIdTo activationPropIdTo) {

        return FastTransformer.switchSchedulers(getAuthService().activation(activationPropIdTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 购买商品
     *
     * /hamster-center/hamsterMarket/activation
     * @return
     */
    public Observable<BaseResponse> buy(MarketBuyTo marketBuyTo) {

        return FastTransformer.switchSchedulers(getAuthService().buy(marketBuyTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 获取当前用户待领取松果数量
     *
     * /hamster-center/hamsterMarket/queryWaitPinecone
     * @return
     */
    public Observable<QueryWaitPineconeResponse> queryWaitPinecone() {

        return FastTransformer.switchSchedulers(getAuthService().queryWaitPinecone().retryWhen(new FastRetryWhen()));
    }


    /**
     * 获取当前用户待领取松果数量
     *
     * /hamster-user/user/updateMobile
     * @return
     */
    public Observable<UpdateMobileResponse> updateMobile(String phone) {

        return FastTransformer.switchSchedulers(getAuthService().updateMobile(phone).retryWhen(new FastRetryWhen()));
    }
}

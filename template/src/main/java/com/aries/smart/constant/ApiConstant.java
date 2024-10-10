package com.aries.smart.constant;

/**
 * @Author: AriesHoo on 2018/11/19 14:14
 * @E-Mail: AriesHoo@126.com
 * @Function: 接口地址常量
 * @Description:
 */
public class ApiConstant {

    /* responseCode */
    public static final String RESPONSE_OK = "200";
    public static final String RESPONSE_FAILED_TO_PASS_REAL_NAME_AUTHENTICATION = "53430"; //未通过实名认证
    public static final String RESPONSE_ACCOUNT_FROZEN = "50118"; //账号已冻结

    /* 	accessFlags 访问标识 0：代表Android；1：代表IOS；可为空 android平台 */
    public static final String TO_ACCOUNT_CREATE_ACCESS_FLAGS_ANDROID = "0";

    /* /hamster-user/sms  sendCode type
     * 类型：2-登录 3-注册 4-注销 5-找回密码 6-绑定手机号码 7-设置二级密码 8-绑定银行卡 9-找回账号 11-验证旧手机 12-快捷认证 13-人工认证 14-转账认证 15-绑定支付宝
     * */
    public static final String SMS_TYPE_LOGIN = "2"; //登录
    public static final String SMS_TYPE_REGISTER = "3"; //注册
    public static final String SMS_TYPE_LOG_OUT = "4"; //注销
    public static final String SMS_TYPE_RETRIEVE_PASSWORD = "5"; //找回密码
    public static final String SMS_TYPE_BIND_MOBILE_PHONE_NUMBER = "6"; //绑定手机号码
    public static final String SMS_TYPE_RETRIEVE_ACCOUNT = "9"; //找回账号
    public static final String SMS_TYPE_VERIFY_OLD_PHONE = "11"; //验证旧手机

    public static final String ACCESSORIES_TYPE_SKIN = "001"; //皮肤
    public static final String ACCESSORIES_TYPE_AVATAR = "002"; //头像

    /*
     *  /hamster-center/hamsterMarket/queryMarketList
     *  商品类型(001-基础仓鼠&仓鼠庄园,003-仓鼠银行)
     */

    public static final String API_HAMSTER_MARKET_TYPE_001 = "001"; //基础仓鼠&仓鼠庄园
    public static final String API_HAMSTER_MARKET_TYPE_003 = "003"; //仓鼠银行


    /*
     *
     * 松果类型：001：松果领取；002：松果转入；003：存折获取；004：市场消费；005：购买皮肤头像；006：任务获得；007：邀新获得；008：养成消费；009 松果转出；010 管理员添加；011 管理员扣除
     * */
    public static final String API_HAMSTER_MARKET_RECORD_LIST_TYPE_ALL = "000"; //所有记录
    public static final String API_HAMSTER_MARKET_RECORD_LIST_TYPE_002 = "002"; //松果转入
    public static final String API_HAMSTER_MARKET_RECORD_LIST_TYPE_009 = "009"; //松果转出


    /**
     * goodsStatue 商品状态 001 商品可购买 002 商品已售磬 003 用户未解锁 004 用户已拥有(待激活) 005 用户已拥有(生效中)
     */
    public static final String GOODS_STATUE_TYPE_001 = "001";
    public static final String GOODS_STATUE_TYPE_002 = "002";
    public static final String GOODS_STATUE_TYPE_003 = "003";
    public static final String GOODS_STATUE_TYPE_004 = "004";
    public static final String GOODS_STATUE_TYPE_005 = "005";

    /**
     * 支付类型 001 松果支付 002 松子支付 003 第三方支付
     */
    public static final String API_HAMSTER_MARKET_PAY_TYPE_001 = "001";
    public static final String API_HAMSTER_MARKET_PAY_TYPE_002 = "002";
    public static final String API_HAMSTER_MARKET_PAY_TYPE_003 = "003";


    /* 登录接口 */
    public static final String API_USER_SMS_SEND_CODE = "/hamster-user/sms/sendCode"; //发送短信验证码
    public static final String API_USER_SMS_VERIFICATION_CODE = "/hamster-user/sms/verificationCode"; //短信验证
    public static final String API_USER_ACCOUNT_CREATE = "/hamster-user/user/accountCreate"; //创建账号
    public static final String API_USER_PASSWORD_LOGIN = "/hamster-user/user/passwordLogin"; //密码登录
    public static final String API_USER_QUERY_PHONE_EXIST = "/hamster-user/user/queryPhoneExist"; //查询号码是否存在
    public static final String API_USER_RESET_USER_LOGIN_PASSWORD = "/hamster-user/user/resetUserLoginPassword"; //忘记用户登录密码
    public static final String API_LOGIN = "/hamster-user/user/login"; //手机号验证码登录(老版本)
    public static final String API_USER_UPDATE_MOBILE = "/hamster-user/user/updateMobile"; //修改手机号绑定
    public static final String API_AUTHENTICATION_SELECTBYUSERID = "/hamster-user/authentication/selectByUserId"; //根据用户id获取用户认证信息
    public static final String API_AUTHENTICATION_INSERTUSERAUTHENTICATION = "/hamster-user/authentication/insertUserAuthentication"; //实名认证
    public static final String API_USER_LOGOFFUSER = "/hamster-user/user/logOffUser"; //注销账号
    public static final String API_USER_ACCOUNTRECOVERY = "/hamster-user/user/accountRecovery"; //恢复账号


    /* 配件接口 */
    public static final String API_ACCESSORIES_INFO_LIST = "/hamster-user/accessories/infoList"; //用户查看饰品头像皮肤首页
    public static final String API_ACCESSORIES_CURRENTLY_USE_SKIN = "/hamster-user/accessories/currentlyUseSkin"; //当前使用头像皮肤
    public static final String API_ACCESSORIES_UNLOCK_SKIN = "/hamster-user/accessories/unlockSkin"; //用户解锁饰品头像皮肤
    public static final String API_ACCESSORIES_WEAR_SKIN = "/hamster-user/accessories/wearSkin"; //用户佩戴饰品头像皮肤

    /* 用户接口 */
    public static final String API_USER_INFO = "/hamster-user/user/info"; //获取会员信息
    public static final String API_USER_UPDATE_NICKNAME = "/hamster-user/user/updateNickname"; //修改昵称
    public static final String API_USER_GET_LEVEL = "/hamster-user/user/level/getLevel"; //获取用户当前等级
    public static final String API_USER_GET_LEVEL_RANK = "/hamster-user/user/level/getLevelRank"; //获取用户当前排行


    /* 钱包 */
    public static final String API_USER_GET_MY_MONEY_BAG = "/hamster-user/userNum/getMyMoneyBag"; //我的钱包
    public static final String API_USER_CHECK_FIRST_UPDATE_NICKNAME = "/hamster-user/user/checkFirstUpdateNickname"; //

    /* 仓鼠市场 */
    public static final String API_CENTER_QUERY_DAY_INCOME = "/hamster-center/hamsterMarket/queryDayIncome"; //获取用户当前每日可获得松果
    public static final String API_CENTER_QUERY_MARKET_LIST = "/hamster-center/hamsterMarket/queryMarketList"; //获取领养仓鼠&仓鼠果园-松果银行列表
    public static final String API_CENTER_MARKET_ACTIVATION = "/hamster-center/hamsterMarket/activation"; //背包物品激活
    public static final String API_CENTER_MARKET_BUY = "/hamster-center/hamsterMarket/buy"; //购买商品
    public static final String API_CENTER_MARKET_QUERYWAITPINECONE = "/hamster-center/hamsterMarket/queryWaitPinecone"; //获取当前用户待领取松果数量
    public static final String API_CENTER_MARKET_QUERY_COLLET_RECORD_LIST = "/hamster-center/hamsterMarket/queryColletRecordList"; //采集记录列表

    /* 任务 */
    public static final String API_TASK_SELECT_TASK_INFO_LIST = "/hamster-task/taskInfo/selectTaskInfoList"; //获取任务列表
}

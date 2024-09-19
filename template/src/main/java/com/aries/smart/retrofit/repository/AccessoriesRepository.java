package com.aries.smart.retrofit.repository;


import com.aries.library.fast.retrofit.FastRetrofit;
import com.aries.library.fast.retrofit.FastRetryWhen;
import com.aries.library.fast.retrofit.FastTransformer;
import com.aries.smart.module.entity.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
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
import com.aries.smart.retrofit.service.AccessoriesService;
import com.aries.smart.retrofit.service.AuthService;

import io.reactivex.Observable;

/**
 * @Function: Accessories 配件接口 皮肤/头像
 * @Description:
 */
public class AccessoriesRepository extends BaseRepository {


    private static volatile AccessoriesRepository instance;
    private AccessoriesService mAccessoriesService;

    private AccessoriesRepository() {
        mAccessoriesService = getAccessoriesService();
    }

    public static AccessoriesRepository getInstance() {
        if (instance == null) {
            synchronized (AccessoriesRepository.class) {
                if (instance == null) {
                    instance = new AccessoriesRepository();
                }
            }
        }
        return instance;
    }

    private AccessoriesService getAccessoriesService() {
        mAccessoriesService = FastRetrofit.getInstance().createService(AccessoriesService.class);
        return mAccessoriesService;
    }

    /**
     * 用户查看饰品头像皮肤首页
     *
     * @return
     */
    public Observable<AccessoriesInfoListResponse> infoList(AccessoriesInfoListTo accessoriesInfoListTo) {

        return FastTransformer.switchSchedulers(getAccessoriesService().infoList(accessoriesInfoListTo).retryWhen(new FastRetryWhen()));
    }

}

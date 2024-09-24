package com.aries.smart.retrofit.repository;


import com.aries.library.fast.retrofit.FastRetrofit;
import com.aries.library.fast.retrofit.FastRetryWhen;
import com.aries.library.fast.retrofit.FastTransformer;
import com.aries.smart.retrofit.request.UnlockSkinTo;
import com.aries.smart.retrofit.request.WearSkinTo;
import com.aries.smart.retrofit.response.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.smart.retrofit.request.CurrentlyUseSkinTo;
import com.aries.smart.retrofit.response.CurrentlyUseSkinResponse;
import com.aries.smart.retrofit.response.UnlockSkinResponse;
import com.aries.smart.retrofit.response.WearSkinResponse;
import com.aries.smart.retrofit.service.AccessoriesService;

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

    /**
     * 当前使用头像皮肤
     *
     * @return
     */
    public Observable<CurrentlyUseSkinResponse> currentlyUseSkin(CurrentlyUseSkinTo currentlyUseSkinTo) {

        return FastTransformer.switchSchedulers(getAccessoriesService().currentlyUseSkin(currentlyUseSkinTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 用户解锁饰品头像皮肤
     *
     * @return
     */
    public Observable<UnlockSkinResponse> unlockSkin(UnlockSkinTo unlockSkinTo) {

        return FastTransformer.switchSchedulers(getAccessoriesService().unlockSkin(unlockSkinTo).retryWhen(new FastRetryWhen()));
    }

    /**
     * 用户佩戴饰品头像皮肤
     *
     * @return
     */
    public Observable<WearSkinResponse> wearSkin(WearSkinTo wearSkinTo) {

        return FastTransformer.switchSchedulers(getAccessoriesService().wearSkin(wearSkinTo).retryWhen(new FastRetryWhen()));
    }

}

package com.aries.smart.retrofit.service;

import com.aries.smart.constant.ApiConstant;
import com.aries.smart.retrofit.request.CurrentlyUseSkinTo;
import com.aries.smart.retrofit.request.UnlockSkinTo;
import com.aries.smart.retrofit.request.WearSkinTo;
import com.aries.smart.retrofit.response.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.smart.retrofit.response.CurrentlyUseSkinResponse;
import com.aries.smart.retrofit.response.UnlockSkinResponse;
import com.aries.smart.retrofit.response.WearSkinResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccessoriesService {



    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_ACCESSORIES_INFO_LIST)
    Observable<AccessoriesInfoListResponse> infoList(@Body AccessoriesInfoListTo accessoriesInfoListTo);


    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_ACCESSORIES_CURRENTLY_USE_SKIN)
    Observable<CurrentlyUseSkinResponse> currentlyUseSkin(@Body CurrentlyUseSkinTo currentlyUseSkinTo);


    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_ACCESSORIES_UNLOCK_SKIN)
    Observable<UnlockSkinResponse> unlockSkin(@Body UnlockSkinTo unlockSkinTo);

    /**
     *
     * @param
     * @return
     */
    @POST(ApiConstant.API_ACCESSORIES_WEAR_SKIN)
    Observable<WearSkinResponse> wearSkin(@Body WearSkinTo wearSkinTo);


}

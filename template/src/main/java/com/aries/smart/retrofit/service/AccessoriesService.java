package com.aries.smart.retrofit.service;

import com.aries.smart.constant.ApiConstant;
import com.aries.smart.module.entity.AccessoriesInfoListResponse;
import com.aries.smart.retrofit.request.AccessoriesInfoListTo;
import com.aries.smart.retrofit.request.PasswordLoginTo;
import com.aries.smart.retrofit.response.PasswordLoginResponse;
import com.aries.smart.retrofit.response.QueryPhoneExistResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AccessoriesService {



    /**
     * 密码登录
     * @param
     * @return
     */
    @POST(ApiConstant.API_ACCESSORIES_INFO_LIST)
    Observable<AccessoriesInfoListResponse> infoList(@Body AccessoriesInfoListTo accessoriesInfoListTo);
/*
    *//**
     * 查询所有用户信息
     * @param
     * @return
     *//*
    @GET(ApiConstant.API_USER_QUERY_PHONE_EXIST)
    Observable<QueryPhoneExistResponse> queryPhoneExist(@Query("phone") String phone);


    *//**
     * 用户查看饰品头像皮肤首页
     * @param
     * @return
     *//*
    @POST(ApiConstant.API_USER_PASSWORD_LOGIN)
    Observable<PasswordLoginResponse> passwordLogin(@Body PasswordLoginTo passwordLoginTo);*/
}

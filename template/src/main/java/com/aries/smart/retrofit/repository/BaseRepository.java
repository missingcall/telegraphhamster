package com.aries.smart.retrofit.repository;

/**
 * @Author: AriesHoo on 2018/10/10 17:24
 * @E-Mail: AriesHoo@126.com
 * @Function: retrofit使用基类封装
 * @Description:
 */
public abstract class BaseRepository {

    /*  TO常量  */


    /*  Response常量  */
    public static final String RESPONSE_OK = "200";
    public static final String RESPONSE_UNAUTHORIZED = "401";
    public static final String RESPONSE_FORBIDDEN = "403";
    public static final String RESPONSE_NOT_FOUND = "404";


    /**
     * @param observable 用于解析 统一返回实体统一做相应的错误码--如登录失效
     * @param <T>
     * @return
     */
/*    protected <T> Observable<T> transform(Observable<BaseResponse<T>> observable) {
        return FastTransformer.switchSchedulers(
                observable.retryWhen(new FastRetryWhen())
                        .flatMap((Function<BaseResponse<T>, ObservableSource<T>>) result -> {
                            if (result == null) {
                                return Observable.error(new NetworkErrorException());
                            } else {
                                if (result.success) {
                                    return result.data != null ? Observable.just(result.data)
                                            : Observable.error(new FastNullException());
                                } else {
                                    return Observable.error(new NetworkErrorException());
                                }
                            }
                        }));
    }*/
}

package com.aries.library.fast.util.rx;

import java.util.HashMap;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by hcc on 16/8/14 17:51
 * 100332338@qq.com
 * RxBus
 * <p/>
 * Subject同时充当了Observer和Observable的角色，Subject是非线程安全的，
 * 要避免该问题，需要将 Subject转换为一个 SerializedSubject ，
 * 上述RxBus类中把线程非安全的PublishSubject包装成线程安全的Subject。
 * <p/>
 * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
 * <p/>
 * ofType操作符只发射指定类型的数据，其内部就是filter+cast
 */
public class RxBus {
    private HashMap<String, CompositeDisposable> mSubscriptionMap;
    private static volatile RxBus mRxBus;
    private final io.reactivex.subjects.Subject<Object> mSubject;

    //单列模式
    public static RxBus getInstance() {
        if (mRxBus == null) {
            synchronized (RxBus.class) {
                if (mRxBus == null) {
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    public RxBus() {
        mSubject = PublishSubject.create().toSerialized();
    }

    public void post(Object o) {
        mSubject.onNext(o);
    }

    /**
     * 返回指定类型的带背压的Flowable实例
     *
     * @param <T>
     * @param type
     * @return
     */
    public <T> Flowable<T> getObservable(Class<T> type) {
        return mSubject.toFlowable(BackpressureStrategy.BUFFER)
                .ofType(type);
    }

    /**
     * 一个默认的订阅方法
     *
     * @param <T>
     * @param type
     * @param next
     * @param error
     * @return
     */
    public <T> Disposable doSubscribe(Class<T> type, Consumer<T> next, Consumer<Throwable> error) {
        return getObservable(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(next, error);
    }

    /**
     * 是否已有观察者订阅
     *
     * @return
     */
    public boolean hasObservers() {
        return mSubject.hasObservers();
    }

    /**
     * 保存订阅后的disposable
     *
     * @param o
     * @param disposable
     */
    public void addSubscription(Object o, Disposable disposable) {
        if (mSubscriptionMap == null) {
            mSubscriptionMap = new HashMap<>();
        }
        String key = o.getClass().getName();
        if (mSubscriptionMap.get(key) != null) {
            mSubscriptionMap.get(key).add(disposable);
        } else {
            //一次性容器,可以持有多个并提供 添加和移除。
            CompositeDisposable disposables = new CompositeDisposable();
            disposables.add(disposable);
            mSubscriptionMap.put(key, disposables);
        }
    }

    /**
     * 取消订阅
     *
     * @param o
     */
    public void unSubscribe(Object o) {
        if (mSubscriptionMap == null) {
            return;
        }

        String key = o.getClass().getName();
        if (!mSubscriptionMap.containsKey(key)) {
            return;
        }
        if (mSubscriptionMap.get(key) != null) {
            mSubscriptionMap.get(key).dispose();
        }

        mSubscriptionMap.remove(key);
    }

    public void release(){
        if (mSubscriptionMap != null){
            for (String key: mSubscriptionMap.keySet()){
                mSubscriptionMap.get(key).dispose();
            }
        }
        mSubscriptionMap.clear();
    }
}

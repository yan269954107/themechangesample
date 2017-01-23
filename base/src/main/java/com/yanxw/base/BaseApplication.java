package com.yanxw.base;

import android.app.Application;

/**
 * BaseApplication
 * Created by yanxinwei on 2017/1/23.
 */

public class BaseApplication extends Application {

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}

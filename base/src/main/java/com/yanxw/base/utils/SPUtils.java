package com.yanxw.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.yanxw.base.BaseApplication;

import java.lang.reflect.Type;

/**
 * SPUtils
 * Created by yanxinwei on 16/9/30.
 */

public class SPUtils {

    private static final String SP_NAME = "goodpic";
    private static SPUtils sInstance;
    private SharedPreferences mManager;

    private SPUtils() {
    }

    public static SPUtils getInstance() {
        if (sInstance == null) {
            sInstance = new SPUtils();
        }
        return sInstance;
    }

    public boolean contains(String key){
        if(checkNull()){
            return false;
        }
        return mManager.contains(key);
    }

    public void putBoolean(String key, boolean value) {
        if(checkNull()){
            return;
        }
        mManager.edit().putBoolean(key, value).apply();
    }

    public void putString(String key, String value) {
        if(checkNull()){
            return;
        }
        mManager.edit().putString(key, value).apply();
    }

    public void putInt(String key, int value) {
        if(checkNull()){
            return;
        }
        mManager.edit().putInt(key, value).apply();
    }

    public void putLong(String key, long value) {
        if(checkNull()){
            return;
        }
        mManager.edit().putLong(key, value).apply();
    }

    public long getLong(String key) {
        if(checkNull()){
            return 0;
        }
        return mManager.getLong(key, 0);
    }

    public long getLong(String key, long value) {
        if(checkNull()){
            return value;
        }
        return mManager.getLong(key, value);
    }

    public int getInt(String key) {
        if(checkNull()){
            return 0;
        }
        return mManager.getInt(key, 0);
    }

    public int getInt(String key, int value) {
        if(checkNull()){
            return value;
        }
        return mManager.getInt(key, value);
    }

    public SharedPreferences.Editor editor() {
        return mManager.edit();
    }

    public String getString(String key) {
        if(checkNull()){
            return "";
        }
        return mManager.getString(key, "");
    }

    public String getString(String key, String def) {
        if(mManager == null){
            return def;
        }
        return mManager.getString(key, def);
    }

    public boolean getBoolean(String key) {
        if(checkNull()){
            return false;
        }
        if(!mManager.contains(key)){
            return false;
        }
        return mManager.getBoolean(key, false);
    }
    public boolean getBoolean(String key, boolean a) {
        if(checkNull()){
            return a;
        }
        if(!mManager.contains(key)){
            return a;
        }
        return mManager.getBoolean(key, a);
    }

    public boolean checkNull() {
        if(mManager == null){
            mManager = BaseApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return false;
    }

    public void recycle() {
        sInstance = null;
        mManager = null;
    }

    public void setBean(String key, Object bean) {
        if(checkNull()){
            return;
        }
        if(bean == null) {
            editor().remove(key).apply();
        } else {
            editor().putString(key, JsonUtil.toJson(bean)).commit();
        }
    }

    public <T> T getBean(String key, Type clazz) {
        if(checkNull()){
            return null;
        }
        String json = mManager.getString(key, null);
        if (TextUtils.isEmpty(json)) return null;
        return JsonUtil.fromJson(json, clazz);
    }

    public void remove(String key) {
        if(checkNull()){
            return;
        }
        mManager.edit().remove(key).apply();
    }

    public SharedPreferences getmManager(){
        return mManager;
    }

}

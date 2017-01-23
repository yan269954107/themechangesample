package com.yanxw.base.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * JsonUtil
 * Created by yanxinwei on 16/9/30.
 */

public class JsonUtil {

    public static final Gson GSON = new Gson();

    public static synchronized String toJson(Object bean) {
        return GSON.toJson(bean);
    }

    public static synchronized <T> T fromJson(String json, Class<T> clazz) {
        try{
            return GSON.fromJson(json, clazz);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized <T> T fromJson(String json, Type type) {
        try{
            return GSON.fromJson(json, type);
        }catch (Exception e){
        }
        return null;

    }

}

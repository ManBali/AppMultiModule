package com.jojo.base.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Created by wushuifang
 * @createtime: on 2017/6/30.
 * @email: wsfjlagr@qq.com
 * @description :
 */
public class ELPublicApiHelper {

    public static Map<Class<? extends ElModuleApi>, ElModuleApi> _ModuleApi = new HashMap<>();

    public static <T extends ElModuleApi> T getModuleApi(Class<?> clazz){
        if (clazz==null){
            return null;
        }

        ElModuleApi api=null;
        if (_ModuleApi.containsKey(clazz)){
            api=_ModuleApi.get(clazz);
        }
        return (T)api;
    }

    public static void register(Class<? extends ElModuleApi> key, ElModuleApi value){
        if (_ModuleApi.containsKey(key)==false){
            _ModuleApi.put(key,value);
        }
    }

    public static void registerAll(Map<Class<? extends ElModuleApi>, ElModuleApi> apis){
        if (apis!=null){
            _ModuleApi.putAll(apis);
        }

    }
    public static void unregister(Class<? extends ElModuleApi> key){
        if (_ModuleApi.containsKey(key)){
            _ModuleApi.remove(key);
        }
    }
}

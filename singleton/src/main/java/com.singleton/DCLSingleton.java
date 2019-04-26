package com.singleton;

/**
 * @Description:
 * @Author: huangl
 * @Date: 2019/4/26 23:27
 */
public class DCLSingleton {

    // 一个静态实例
    private static DCLSingleton dclSingleton;

    // 私有构造方法
    private DCLSingleton(){}

    // 公共获取实例方法
    public static DCLSingleton getInstance(){
        if (dclSingleton == null){
            synchronized (DCLSingleton.class){
                if (dclSingleton == null){
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }
}

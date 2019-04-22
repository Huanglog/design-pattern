package com.singleton;

/**
 * @Description:
 * @Author: huangl
 * @Date: 2019/4/22 23:55
 */
public class SynchronizedSingleton {

    // 一个静态的实例
    private static SynchronizedSingleton synchronizedSingleton;

    //私有构造方法
    private SynchronizedSingleton(){}

    public synchronized static SynchronizedSingleton getInstance(){
        if (synchronizedSingleton == null){
            synchronizedSingleton = new SynchronizedSingleton();
        }
        return synchronizedSingleton;
    }
}

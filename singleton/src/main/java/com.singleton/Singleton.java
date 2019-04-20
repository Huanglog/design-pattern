package com.singleton;

/**
 * @Description:
 * @Author: huangl
 * @Date: 2019/4/20 20:18
 */
public class Singleton {
    // 静态实例
    private static Singleton singleton;
    // 私有构造方法
    private Singleton(){};

    // 给出公共静态方法返回单一实例
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

}

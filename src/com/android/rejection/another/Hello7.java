package com.android.rejection.another;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2016/8/19.
 * 获得其他类中的全部构造函数
 */
public class Hello7 {
    public static void main(String[] args) {
        Class<?> demo = null;

        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Constructor<?> cons[] = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            System.out.println("构造方法   " + cons[i]);
        }
    }

}

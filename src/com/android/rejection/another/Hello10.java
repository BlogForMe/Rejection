package com.android.rejection.another;

import java.lang.reflect.Method;

/**
 * Created by Jon on 2016/8/21.
 * 其实还可以通过反射调用其它类中的方法
 */
public class Hello10 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //调用Person类中的sayChina方法
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());

            //调用Person的sayHello方法
            method  = demo.getMethod("sayHello",String .class,int.class);
            method.invoke(demo.newInstance(),"Jon",26);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

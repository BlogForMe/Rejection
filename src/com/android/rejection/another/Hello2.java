package com.android.rejection.another;


import com.android.rejection.JavaBean.Demo;

/**
 * Created by Administrator on 2016/8/19.
 * 实例化class实例对象
 * <p>
 * //所有的类的对象其实都是Class的实例
 */


public class Hello2 {
    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("com.android.rejection.JavaBean.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        demo2 = new Demo().getClass();
        demo3 = Demo.class;
        System.out.println("类名称" + demo1.getName());
        System.out.println("类名称" + demo2.getName());
        System.out.println("类名称" + demo3.getName());

    }
}

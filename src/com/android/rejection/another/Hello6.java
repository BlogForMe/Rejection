package com.android.rejection.another;

/**
 * Created by Administrator on 2016/8/19.
 * 取得其他类中的父类
 */
public class Hello6 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //取得父类
        Class<?> temp = demo.getSuperclass();
        System.out.println("继承的父类: " + temp.getName());
    }
}

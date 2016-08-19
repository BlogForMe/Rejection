package com.android.rejection.another;

/**
 * Created by Administrator on 2016/8/19.
 * 返回一个类实现的接口
 */
public class Hello5 {
    public static void main(String[] args) {
        Class<?> demo = null;

        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //保存所有的接口
        Class<?> interfaces[] = demo.getInterfaces();
        for (int i = 0; i < interfaces.length; i++)
            System.out.println("实现的接口   " + interfaces[i].getName());
    }
}

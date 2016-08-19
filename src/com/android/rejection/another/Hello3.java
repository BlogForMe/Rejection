package com.android.rejection.another;

import com.android.rejection.JavaBean.Person;

/**
 * Created by Administrator on 2016/8/19.
 * 通过无参构造方法实例化对象
 */
public class Hello3 {
    public static void main(String[] args) {

        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person");//使用此Constructor对象表示的构造方法来创建该构造方法的声明类的新实例
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person per = null;
        try {
            per = (Person) demo.newInstance();  //实例化
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        per.setName("Rollen");
        per.setAge(20);
        System.out.println(per);
    }
}

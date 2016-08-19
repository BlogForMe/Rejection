package com.android.rejection.another;

import com.android.rejection.JavaBean.Person;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2016/8/19.
 * 通过Class调用其它类中的构造函数（也可以通过这种方式通过Class创建其他类的对象）
 */
public class Hello4 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person per1 = null;
        Person per2 = null;
        Person per3 = null;
        Person per4 = null;

        //取得全部的构造函数
        Constructor<?> cons[] = demo.getConstructors();
        try {
            per1 = (Person) cons[3].newInstance();
            per2 = (Person) cons[2].newInstance("Jon");
            per3 = (Person) cons[1].newInstance(20);
            per4 = (Person) cons[0].newInstance("ll", 25);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);

    }
}

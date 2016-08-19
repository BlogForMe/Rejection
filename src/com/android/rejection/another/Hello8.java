package com.android.rejection.another;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2016/8/19.
 * 获取构造函数的修饰符
 */
public class Hello8 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<?> cons[] = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            Class<?> p[] = cons[i].getParameterTypes();
            System.out.print("构造方法：  ");
            int mo = cons[i].getModifiers();
            System.out.println(Modifier.toString(mo) + " ");
            System.out.println(cons[i].getName());
            System.out.print("(");
            for (int j = 0; j < p.length; ++j) {
                System.out.println(p[j].getName() + " arg" + i);
                if (j < p.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }


    }
}

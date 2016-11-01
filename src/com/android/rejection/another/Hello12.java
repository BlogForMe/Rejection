package com.android.rejection.another;


import java.lang.reflect.Field;

/**
 * Created by Jon on 2016/8/21.
 * 通过反射操作属性
 */
public class Hello12 {
    public static void main(String[] args) throws Exception {
        Class<?> demo = null;
        Object obj = null;
        demo = Class.forName("com.android.rejection.JavaBean.Person5");
        obj = demo.newInstance();


        Field field = demo.getDeclaredField("sex");

        field.setAccessible(true);
        field.set(obj, "男"); //直接操作属性
        System.out.println(field.get(obj));
    }
}

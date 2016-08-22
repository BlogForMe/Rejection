package com.android.rejection.another;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by Jon on 2016/8/21.
 * 调用其它类的set和get方法
 */
public class Hello11 {
    public static void main(String[] args) {
        Class<?> demo = null;
        Object obj = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            obj = demo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setter(obj, "Sex", "男", String.class);

        getter(obj, "Sex");


    }

    /**
     * @param obj 操作的对象
     * @param att 操作的属性
     */
    private static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param obj   操作的对象
     * @param att   操作的属性
     * @param value 设置的值
     * @param type  参数的属性
     */
    private static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type); //操作方法
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

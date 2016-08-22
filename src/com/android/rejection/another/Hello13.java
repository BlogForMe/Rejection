package com.android.rejection.another;

import java.lang.reflect.Array;

/**
 * Created by Jon on 2016/8/21.
 * 通过反射取得并修改数组的信息
 */
public class Hello13 {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }

}

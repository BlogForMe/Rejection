package com.android.rejection.another;

/**
 * Created by Jon on 2016/8/21.
 * 动态代理
 */
public class Hello15 {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("类加载器" + t.getClass().getClassLoader().getClass().getName());
    }
}

class Test {

}
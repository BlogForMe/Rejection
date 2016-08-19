package com.android.rejection.another;

import com.android.rejection.JavaBean.Demo;

/**
 * Created by Administrator on 2016/8/19.
 * 通过一个对象获得完整的包名和类名
 */


public class Hello1 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getClass());
    }
}


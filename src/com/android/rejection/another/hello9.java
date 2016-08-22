package com.android.rejection.another;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Jon on 2016/8/21.
 * 接下来让我们取得其他类的全部属性吧，最后我讲这些整理在一起，也就是通过class取得一个类的全部框架
 */
public class hello9 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.android.rejection.JavaBean.Person5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("本类属性");

        //取得本类的全部属性
        Field[] fileds = demo.getDeclaredFields();
        for (Field field : fileds) {
            //权限修饰符
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = field.getType();
            System.out.println(priv + " " + type.getName() + ";");
        }

        System.out.println("==实现的接口或者父类的属性===");

        Field[] fields1 = demo.getFields();
        for (Field field : fields1) {
            //权限修饰符
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = field.getType();
            System.out.println(priv + " " + type.getName() + " " + field.getName() + ";");
        }


    }

}

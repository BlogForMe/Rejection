package com.android.rejection.another;

import com.android.rejection.factoryMode.Fruit;

import java.io.*;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by Administrator on 2016/8/22.
 * <p>
 * <p>
 * 上面的爱吗虽然可以通过反射取得接口的实例，但是需要传入完整的包和类名。而且用户也无法知道一个接口有多少个可以使用的子类，所以我们通过属性文件的形式配置所需要的子类。
 * <p>
 * 下面我们来看看： 结合属性文件的工厂模式
 * <p>
 * 首先创建一个fruit.properties的资源文件，
 */


class init {
    public static Properties getPro() throws FileNotFoundException, IOException {
        Properties pro = new Properties();
        File f = new File("fruit.properties");
        if (f.exists()) {
            pro.load(new FileInputStream(f));
        } else {
            pro.setProperty("apple", "com.android.rejection.factoryMode.Apple");
            pro.setProperty("orange", "com.android.rejection.factoryMode.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}


public class Hello18 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties pro = init.getPro();
        Fruit f = Factory.getInstance(pro.getProperty("apple"));
        if (f != null)
            f.eat();
    }
}

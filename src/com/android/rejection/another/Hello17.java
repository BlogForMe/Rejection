package com.android.rejection.another;

import com.android.rejection.factoryMode.Fruit;

/**
 * Created by Administrator on 2016/8/22.
 * 类的生命周期
 * <p>
 * 在一个类编译完成之后，下一步就需要开始使用类，如果要使用一个类，肯定离不开JVM。在程序执行中JVM通过装载，链接，初始化这3个步骤完成。
 * <p>
 * 类的装载是通过类加载器完成的，加载器将.class文件的二进制文件装入JVM的方法区，并且在堆区创建描述这个类的java.lang.Class对象。用来封装数据。 但是同一个类只会被类装载器装载以前
 * <p>
 * 链接就是把二进制数据组装为可以运行的状态。
 * <p>
 * <p>
 * <p>
 * 链接分为校验，准备，解析这3个阶段
 * <p>
 * 校验一般用来确认此二进制文件是否适合当前的JVM（版本），
 * <p>
 * 准备就是为静态成员分配内存空间，。并设置默认值
 * <p>
 * 解析指的是转换常量池中的代码作为直接引用的过程，直到所有的符号引用都可以被运行程序使用（建立完整的对应关系）
 * <p>
 * 完成之后，类型也就完成了初始化，初始化之后类的对象就可以正常使用了，直到一个对象不再使用之后，将被垃圾回收。释放空间。
 * <p>
 * 当没有任何引用指向Class对象时就会被卸载，结束类的生命周期
 * <p>
 * <p>
 * 将反射用于工厂模式
 * <p>
 * 先来看看，如果不用反射的时候，的工厂模式吧：
 * <p>
 * http://www.cnblogs.com/rollenholt/archive/2011/08/18/2144851.html
 *
 * @author Jon 设计模式-工厂模式-反射机制
 */


public class Hello17 {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("com.android.rejection.factoryMode.Apple");
        if (f != null)
            f.eat();
    }
}

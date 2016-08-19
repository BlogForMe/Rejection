package com.android.rejection.oneDemo;


import java.lang.reflect.*;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        Demo1();

//        demo2();

//        demo3();

//        Demo4();

//        Demo5();

//        Demo6();
//        Demo7();
        Demo8();
    }


    //通过Java反射机制得到累的包名和类名
    private static void Demo1() {
        Person person = new Person();
        System.out.println("Demo1: 包名： " + person.getClass().getPackage().getName() + ", " + "完整的包名： " + person.getClass().getName());
    }

    //验证所有的类都是Class类的实例对象
    private static void demo2() {
        //定义两个类型未知的Class，设置初值为null,看看如何给他们赋值成Person类
        Class<?> class1 = null;
        Class<?> class2 = null;
        //写法1，可能抛出 ClassNotFoundException
        try {
            class1 = Class.forName("com.android.rejection.Person");
            System.out.println("Demo2:(写法1) 包名：" + class1.getPackage().getName() + ", " + class1.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Java反射机制，用Class创建类对象 这也是反射存在的意义
     */
    private static void demo3() {
        Class<?> class1 = null;
        try {
            class1 = Class.forName("com.android.rejection.Person");
            //由于这里不能带参数，所以你要实例化这个类Person，一定要无参构造函数
            Person person = (Person) class1.newInstance();
            person.setAge(20);
            person.setName("LeeFeng");
            System.out.println("Demo3: " + person.getName() + " :" + person.getAge());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Demo4 通过JAVA反射机制得到一个类的构造函数，并实现创建带参实例对象
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private static void Demo4() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;
        class1 = Class.forName("com.android.rejection.Person");
        //得到一系列构造函数集合
        Constructor<?>[] constructors = class1.getConstructors();
        person1 = (Person) constructors[0].newInstance();
        person1.setAge(26);
        person1.setName("leeFeng");
        person2 = (Person) constructors[1].newInstance(20, "Jon");
        System.out.println("Demo4 : " + person1.getName() + " : " + person1.getAge() + " ," + person2.getName() + ":" + person2.getAge());
    }

    /**
     * Demo5 : 通过JAVA反射机制操作成员变量，set和 get
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public static void Demo5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Class<?> class1 = null;
        class1 = Class.forName("com.android.rejection.Person");
        Object obj = class1.newInstance();
        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true);
        personNameField.set(obj, "周先森");
        System.out.println("Demo5:修改属性之后得到属性变量的值： " + personNameField.get(obj));
    }

    /**
     * Demo6 : 通过Java反射机制得到类的一些属性
     *
     * @throws ClassNotFoundException
     */
    public static void Demo6() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.android.rejection.SuperMan");

        //取得父类名称
        Class<?> superClass = class1.getSuperclass();
        System.out.println("Demo6: SuperMan类的父类名 ： " + superClass.getName());

        System.out.println("=========================================");

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("类中的成员 ： " + fields[i]);
        }
        System.out.println("==========================================");

        //取得类方法
        Method[] methods = class1.getDeclaredMethods();
        System.out.println("Demo6.取得Person类中的方法");
        for (int i = 0; i < methods.length; i++) {
            System.out.println("函数名 ： " + methods[i].getName());
            System.out.println("函数返回类型 ： " + methods[i].getReturnType());
            System.out.println("函数访问修饰符: " + Modifier.toString(methods[i].getModifiers()));
            System.out.println("函数代码写法 : " + methods[i]);
            System.out.println();
        }
        System.out.println("======================================");

        //取得类实现的接口，因为接口类也属于Class ,所以的到接口中的方法也是同种方式
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++)
            System.out.println("实现的接口类名 ： " + interfaces[i].getName());
    }

    /**
     * 通过JAVA反射机制调用类方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void Demo7() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> class1 = null;
        class1 = Class.forName("com.android.rejection.SuperMan");

        System.out.println("Demo7: \n 调用无参数方法fy1()");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("调用有参数方法walk(int m)");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);
    }

    /**
     * Demo 8 : 通过JAVA反射机制得到类加载信息
     *
     * @throws ClassNotFoundException
     */
    public static void Demo8() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.android.rejection.SuperMan");
        String nameStirng = class1.getClassLoader().getClass().getName();
        System.out.println("Demo8 : 类加载器类名 " + nameStirng);
    }

}

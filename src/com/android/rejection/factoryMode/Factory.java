package com.android.rejection.factoryMode;

/**
 * Created by Administrator on 2016/8/22.
 * 构造工厂类
 *也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
 */
class Factory {
    public static Fruit getInstance(String fruitName) {
        Fruit f = null;
        if ("Apple".equals(fruitName)) {
            f = new Apple();
        }

        if ("Orange".equals(fruitName)) {
            f = new Orange();
        }
        return f;
    }
}

class hello {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("Orange");
        f.eat();

    }
}
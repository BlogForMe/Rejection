package com.android.rejection.another;

import com.android.rejection.factoryMode.Fruit;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
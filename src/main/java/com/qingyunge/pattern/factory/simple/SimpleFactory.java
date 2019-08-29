package com.qingyunge.pattern.factory.simple;

import com.qingyunge.pattern.factory.Milk;
import com.qingyunge.pattern.factory.TeLunSu;
import com.qingyunge.pattern.factory.YiLi;

public class SimpleFactory {

    public Milk getMilk(String name) {

        if ("特仑苏".equals(name)) {
            return new TeLunSu();
        }

        if ("伊利".equals(name)) {
            return new YiLi();
        }


        return null;
    }

}

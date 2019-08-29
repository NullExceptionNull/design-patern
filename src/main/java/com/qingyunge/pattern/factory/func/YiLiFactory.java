package com.qingyunge.pattern.factory.func;

import com.qingyunge.pattern.factory.Milk;
import com.qingyunge.pattern.factory.TeLunSu;
import com.qingyunge.pattern.factory.YiLi;

public class YiLiFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}

package com.qingyunge.pattern.factory.abstr;

import com.qingyunge.pattern.factory.Milk;
import com.qingyunge.pattern.factory.TeLunSu;
import com.qingyunge.pattern.factory.YiLi;

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        return new TeLunSu();
    }

    @Override
    public Milk getYiLi() {
        return new YiLi();
    }
}

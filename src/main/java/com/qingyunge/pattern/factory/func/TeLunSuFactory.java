package com.qingyunge.pattern.factory.func;

import com.qingyunge.pattern.factory.Milk;
import com.qingyunge.pattern.factory.TeLunSu;

public class TeLunSuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new TeLunSu();
    }
}

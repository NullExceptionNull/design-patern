package com.qingyunge.pattern.factory.func;

import com.qingyunge.pattern.factory.Milk;

public interface Factory {

    //工厂必有生产产品的技能 统一的产品出口
    Milk getMilk();
}

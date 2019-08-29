package com.qingyunge.pattern.factory.simple;

import com.qingyunge.pattern.factory.Milk;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        //System.out.println(new TeLunSu().getName());

        //首先得到一个工厂 用户本身不在关心生产过程
        SimpleFactory simpleFactory = new SimpleFactory();

        //把用户的需求告诉工厂
        Milk milk = simpleFactory.getMilk("特仑苏");

        System.out.println(milk.getName());
    }
}

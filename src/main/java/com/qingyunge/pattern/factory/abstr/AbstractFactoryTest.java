package com.qingyunge.pattern.factory.abstr;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        MilkFactory milkFactory = new MilkFactory();

        System.out.println(milkFactory.getTelunsu().getName());
    }

}

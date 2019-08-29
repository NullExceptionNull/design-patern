package com.qingyunge.pattern.factory.func;

public class FactoryTest {

    public static void main(String[] args) {

        String name = new YiLiFactory().getMilk().getName();
        System.out.println(name);
    }

}

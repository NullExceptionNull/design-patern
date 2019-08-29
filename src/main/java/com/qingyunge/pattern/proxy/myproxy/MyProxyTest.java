package com.qingyunge.pattern.proxy.myproxy;

import com.qingyunge.pattern.proxy.staticproxy.Person;
import com.qingyunge.pattern.proxy.staticproxy.Son;

public class MyProxyTest {

    public static void main(String[] args) throws Exception {

        Person instance = (Person)new MyMeipo().getInstance(new Son());
        System.out.println(instance.getClass());
        instance.findLove();

    }
}

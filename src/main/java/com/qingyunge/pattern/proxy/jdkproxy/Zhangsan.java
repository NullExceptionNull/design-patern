package com.qingyunge.pattern.proxy.jdkproxy;

import com.qingyunge.pattern.proxy.staticproxy.Person;

public class Zhangsan implements Person {
    @Override
    public void findLove() {
        System.out.println("找对象，我要找对象");
    }

    @Override
    public void findJob() {

    }
}

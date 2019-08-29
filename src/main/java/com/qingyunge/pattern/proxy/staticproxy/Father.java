package com.qingyunge.pattern.proxy.staticproxy;

public class Father implements Person {

    //需要拿到被代理对象的引用

    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    public void findLove() {
        System.out.println("帮人家找对象");
        this.person.findLove();
        System.out.println("找到了");
    }

    public void findJob() {

    }
}

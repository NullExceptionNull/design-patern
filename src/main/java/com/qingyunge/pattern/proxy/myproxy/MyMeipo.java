package com.qingyunge.pattern.proxy.myproxy;

import com.qingyunge.pattern.proxy.staticproxy.Person;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyMeipo implements MyInocationHandler {

    //首先拿到被代理对象的引用
    private Person person;

    public Object getInstance(Person person) throws Exception {
        this.person = person;

        return MyProxy.newProxyInstance(new MyClassLoader(), person.getClass().getInterfaces(), this);
    }


    //这里是代理类的执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是自己生成代理类");

        method.invoke(this.person, args);

        System.out.println("代理类执行完毕");

        return null;
    }
}

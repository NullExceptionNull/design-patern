package com.qingyunge.pattern.proxy.jdkproxy;

import com.qingyunge.pattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeipo implements InvocationHandler {

    //首先拿到被代理对象的引用
    private Person person;

    public Object getInstance(Person person) {
        this.person = person;

        return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }


    //这里是代理类的执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是代理类");

        method.invoke(this.person, args);

        System.out.println("代理类执行完毕");

        return null;
    }
}

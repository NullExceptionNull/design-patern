package com.qingyunge.pattern.proxy.myproxy;

import java.lang.reflect.Method;

public interface MyInocationHandler {
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}

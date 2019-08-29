package com.qingyunge.pattern.proxy.jdkproxy;

import cn.hutool.core.io.FileUtil;
import com.qingyunge.pattern.proxy.staticproxy.Person;
import sun.misc.ProxyGenerator;

public class JdkMeipoTest {

    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        Person person = (Person) jdkMeipo.getInstance(new Zhangsan());
        person.findLove();
        System.out.println(person.getClass());


        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});

        FileUtil.writeBytes(bytes,"C:\\code\\design-patern\\src\\main\\java\\com\\qingyunge\\pattern\\proxy\\jdkproxy\\proxyclazz.class");

    }
}

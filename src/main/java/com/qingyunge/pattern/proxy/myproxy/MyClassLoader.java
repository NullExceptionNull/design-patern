package com.qingyunge.pattern.proxy.myproxy;

import cn.hutool.core.io.FileUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private File classPathFile;

    public MyClassLoader() {

        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;

        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {

                byte[] bytes = FileUtil.readBytes(classFile);
                return defineClass(className, bytes, 0, bytes.length);

            }
            return null;

        }
        return null;
    }
}

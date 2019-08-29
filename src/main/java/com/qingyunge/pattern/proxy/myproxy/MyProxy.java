package com.qingyunge.pattern.proxy.myproxy;

import cn.hutool.core.io.FileUtil;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class MyProxy {

    public static final String ln = "\r\n";


    public static Object newProxyInstance(MyClassLoader myClassLoader, Class<?>[] interfaces, MyInocationHandler handler) throws Exception {
        //1 动态生成源代码java文件 需要继承N多接口
        String src = generate(interfaces);

        String path = MyProxy.class.getResource("").getPath();

        File f = new File(path + "$Proxy0.java");

        FileUtil.writeString(src, f, Charset.defaultCharset());

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = manage.getJavaFileObjects(f);

        JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
        task.call();
        manage.close();


        //4、编译生成的.class文件加载到JVM中来
        Class proxyClass = myClassLoader.findClass("$Proxy0");
        Constructor c = proxyClass.getConstructor(MyInocationHandler.class);

        //5、返回字节码重组以后的新的代理对象
        return c.newInstance(handler);


    }

    private static String generate(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();

        sb.append("package com.qingyunge.pattern.proxy.myproxy;" + ln);
        sb.append("import com.qingyunge.pattern.proxy.staticproxy.Person;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(ln);

        sb.append("MyInocationHandler h;");

        sb.append("public $Proxy0(MyInocationHandler h) { " + ln);
        sb.append("this.h = h;");

        sb.append("}" + ln);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}");
            sb.append("}");
        }


        sb.append("}" + ln);

        return sb.toString();
    }
}

package cn.ccTengx.day0226.Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String classname();
    String methodname();
}*/
@Pro(classname = "cn.ccTengx.day0226.Demo.DemoTest",methodname ="show" )
public class DemoTest {
    public void show(){
        System.out.println("Demo1...show");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.解析注解...获取该类字节码文件对象
        Class<DemoTest> demoTestClass = DemoTest.class;
        //2.获取指定类型的注解
        Pro annotation = demoTestClass.getAnnotation(Pro.class);
        /*原理
        public class ProImp implements Pro{
            String classname(){return "cn.ccTengx.day0226.Demo.DemoTest";}
            String methodname(){return "show";}}
        */
        //3.调用注解定义的抽象方法
        String classname=annotation.classname();
        String methodname=annotation.methodname();
        //4.加载该类进内存
        Class aClass = Class.forName(classname);
        //5.创建对象
        Object o = aClass.newInstance();
        //6.获取方法对象
        Method method = aClass.getMethod(methodname);
        //7.执行该方法
        method.invoke(o);
    }
}

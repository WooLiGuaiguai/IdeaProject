package cn.ccTengx.day0225_Test;

import cn.ccTengx.day0224.StreamTest.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class peopleclass=Person.class;
        /*getFields 方法 获取的是成员变量数组 或指定名称的成员变量
        并且都是public 修饰符修饰的
        输出结果 public java.lang.String cn.ccTengx.day0224.StreamTest.Person.a*/
        Field[]fields=peopleclass.getFields();
        for(int i=0;i<fields.length;i++){
            System.out.print(fields[i]+" ");
        }
        System.out.println();
        //Field getField(String name) name是指定义的变量的名字
        Field fields1=peopleclass.getField("age");
        System.out.println(fields1);
        //获取成员变量的值 需要先传参一个类对象 String类型变量 如果不定义 默认为null
        Person p=new Person();
        Object o=fields1.get(p);//o.value==null
        //设置成员变量的值
        fields1.set(p,250);

        //Field[] getDeclaredFields()不考虑修饰符 访问所有成员变量
        Field[]fs=peopleclass.getDeclaredFields();
        for(int i=0;i<fs.length;i++){
            System.out.print(fs[i]+" ");
        }
        System.out.println();
        //Field getDeclaredField(String name) 不能访问public之外的成员变量
        //但是可以 忽略访问权限修饰符的安全检查
        Field fs1=peopleclass.getDeclaredField("name");
        fs1.setAccessible(true);//暴力反射
        Object o1=fs1.get(p);
        System.out.println(o1);

        //Constructor<T> getConstructor(类<?>... parameterTypes)
        //Constructor<?>[] getConstructors()返回包含一个数组 Constructor对象反射由此表示的类的所有公共构造 类对象。
        Class person2=Person.class;
        Constructor constructor=person2.getConstructor(String.class,int.class);
        Object person=constructor.newInstance("马小跳",25);
        //使用空参构造方法时  可以简化直接使用类的newInstance方法
        Class person3=Person.class;
        Object o2=person3.newInstance();
        //如果使用私有的构造方法 也需要注意进行暴力反射  构造器.setAccessible( );
        constructor.setAccessible(true);
        System.out.println(o2);

        //getMethod(String name, 类<?>... parameterTypes)  传递的参数是方法的名称 以及方法的参数列表
        //首先使用的是空参方法
        Class person4=Person.class;
        Method method1=person4.getMethod("eat");
        //Method.invoke  调用该方法   invoke这个函数的参数是对象 以及方法的参数列表
        Person p1=new Person();
        method1.invoke(p1);

        //然后是带参数方法
        Class person5=Person.class;
        Method method2=person5.getMethod("drink", int.class);
        method2.invoke(p1,5);

        //获取所有方法 不但会显示自己定义的  还有隐藏的
        //public native int java.lang.Object.hashCode()
        //public final native java.lang.Class java.lang.Object.getClass()
        //public final native void java.lang.Object.notify()
       // public final native void java.lang.Object.notifyAll()
        Method[]methods=person5.getMethods();
        for (Method m:methods) {
            System.out.println(m);
        }
        /*//使用私有方法
            private int sss(String d){
            System.out.print("加油 奥利给  "+d);
            return age+10;
        }*/
        Method method=person5.getDeclaredMethod("sss",String.class);
        Person p2=new Person();
        method.setAccessible(true);
        System.out.println(method.invoke(p2,"冲啊"));//加油 奥利给  冲啊   10
        //获取方法名称
        System.out.println(method.getName());//sss
        //获取类名方法
        person5.getName();



    }
}

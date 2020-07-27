package cn.ccTengx.day0225_Test;

import cn.ccTengx.day0223.Practices;
import cn.ccTengx.day0224.StreamTest.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BirthdayTest {
    /*
    * 初始化方法
    * 用于资源申请，所有测试方法在执行之前都会执行该方法*/
    @Before
    public void inittest(){
        System.out.println("初始化");
    }
    /*
    * 释放资源方法
    * 在所有测试结果执行完成之后都会执行该方法  不管前面执行的方法是否报错*/
    @After
    public void close(){
        System.out.println("释放资源");
    }
    @Test
    public void testbirthday(){
        Practices practices=new Practices();
        int []arr={7,5,6,4};
        System.out.println(practices.InversePairs(arr));
        Assert.assertEquals(5,practices.InversePairs(arr));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class cls1=Class.forName("cn.ccTengx.day0224.StreamTest.Person");
        System.out.println(cls1);

        Class cls2=Person.class;
        System.out.println(cls2);

        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);
        //同一个字节码文件 .class 在一次程序运行过程中 只会被加载一次
        System.out.println(cls1==cls2);//同一个类
    }
}

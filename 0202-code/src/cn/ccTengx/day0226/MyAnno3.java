package cn.ccTengx.day0226;

import java.lang.annotation.*;

//元注解
//Target描述注解能够作用的位置  下面分别表示可以作用于 类、方法、变量 上
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
//Retention 描述注解被保留的阶段  当前被描述的注解会被保留到class字节码文件中 并被jvm读取到
@Retention(RetentionPolicy.RUNTIME)
//Documented 描述注解是否被抽取到api文档中
@Documented
//Inherited 描述注解是否被子类继承
@Inherited
public @interface MyAnno3 {
}

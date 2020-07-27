package cn.ccTengx.day0215;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisteerDemoTest {

    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("李四");
        list.add("王五");
        list.add("赵⑧");
        list.add("A6");
        System.out.println("输入你要注册的用户名");
        Scanner sc=new Scanner(System.in);
        String next = sc.next();
        addCheck(next,list);

    }
    public static void addCheck(String string,ArrayList<String> list)  {
        for (String s : list) {
            if(string.equals(s)){
                throw new RegisterExceptionDemo("与数据库中用户名冲突");
            }
        }
        list.add(string);
        System.out.println("添加成功");
    }
}

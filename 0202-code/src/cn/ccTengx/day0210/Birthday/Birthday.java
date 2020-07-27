package cn.ccTengx.day0210.Birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) throws ParseException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入你的生日");
        String str=scanner.next();
        //先将字符串转化成日期
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=dateFormat.parse(str);
        System.out.println(date);
        //日期转化成毫秒
        long time1=date.getTime();
        //获取当前时间
        long time2=new Date().getTime();
        //转化成天数
        System.out.println((time2-time1)/1000/60/60/24);
    }
}

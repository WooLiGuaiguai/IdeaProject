package cn.ccTengx.day0214;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        show1();
    }

    private static void show1() {
        Map<String,String> map=new HashMap<>();
        String str1=map.put("li晨","范冰冰");
        String str2=map.put("li晨","范冰冰2");
        System.out.println(str1);
        System.out.println(str2);
        map.put("迪丽热巴","1111");
        map.put("古力娜扎","1111");
        map.put("马尔扎哈","2211");
        System.out.println(map);
    }
}

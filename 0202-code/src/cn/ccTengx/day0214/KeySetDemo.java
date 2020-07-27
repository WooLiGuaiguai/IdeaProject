package cn.ccTengx.day0214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KeySetDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("li晨","范冰冰");
        map.put("迪丽热巴","1111");
        map.put("古力娜扎","1111");
        map.put("马尔扎哈","2211");

        Set<String> set=map.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String str=iterator.next();
            String string=map.get(str);
            System.out.println(str+"  "+string);
        }
        for (String s:set) {
            String string=map.get(s);
            System.out.println(s+"  "+string);
        }
    }
}

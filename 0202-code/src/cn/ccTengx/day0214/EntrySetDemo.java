package cn.ccTengx.day0214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EntrySetDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("li晨","范冰冰");
        map.put("迪丽热巴","1111");
        map.put("古力娜扎","1111");
        map.put("马尔扎哈","2211");

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println(key+" "+value);
        }
        for (Map.Entry<String, String> stringStringEntry : set) {
            System.out.println(stringStringEntry.getKey()+" "+stringStringEntry.getValue());
        }
    }
}

package huawei;

import java.util.*;

public class one {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        String [] str={"Tom","Lily","Tom","Lucy","Lucy","Jackk"};
        System.out.println(star(str));

    }
    public static String star(String [] people){
        Map<String,Integer>peo_num=new HashMap<>();
        for (String p : people) {//首先先计算他们的出现的次数
            peo_num.put(p,peo_num.getOrDefault(p,0)+1);
        }
        List<String>[] Lists=new ArrayList[people.length+1];
        Set<String> person = peo_num.keySet();
        for (String key : person) {
            Integer value = peo_num.get(key);//获得频率值
            if(Lists[value]==null){
                Lists[value]=new ArrayList<>();
            }
            Lists[value].add(key);
        }
        int i=Lists.length-1;
        for(;i>0;i++){
            if(Lists[i].size()!=0){
                break;
            }
        }
        List<String> list=Lists[i];
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(0);
    }
}

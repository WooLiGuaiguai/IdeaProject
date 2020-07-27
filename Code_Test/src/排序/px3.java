package 排序;

import java.util.*;

public class px3 {
    public static void main(String[] args) {
        int []num={1,2,3,1,1,1,2,2,3,4,4,5,5,6,6,7};
        List<Integer> list=topKFrequent(num,6);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        String str="treeabddddd";
        System.out.println(frequencySort(str));;
    }
    public static String frequencySort(String s){
        char [] chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0)+1);
        }
        List<Character> [] lists=new ArrayList[chars.length+1];
        for (char ch : map.keySet()) {
            int fre = map.get(ch);
            if(lists[fre]==null){
                lists[fre]=new ArrayList<>();
            }
            lists[fre].add(ch);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=lists.length-1;i>=0;i--){//i由上面知 代表频率
            if (lists[i]==null){
                continue;
            }
            for(char c:lists[i]){//lists[i]代表出现频率为i的集合里面的元素
                for(int k=0;k<i;k++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    public static List<Integer> topKFrequent(int[] nums, int k){
        //首先分析是前k个出现次数最多的数 有可能这k个数出现的次数是一样的 有可能是不一样的
        //记录一个数以及他出现的次数 使用Map集合
        Map<Integer,Integer> NumAndFre=new HashMap<>();
        for (int num : nums) {//首先先计算他们的出现的次数
            NumAndFre.put(num,NumAndFre.getOrDefault(num,0)+1);
        }
        //然后分桶 每个桶是一个List集合，每个List集合中是频率相同的数  所有的集合再构成一个集合进行遍历
        List<Integer>[] Lists=new ArrayList[nums.length+1];
        Set<Integer> integers = NumAndFre.keySet();//找到数字的集合
        for (Integer key : integers) {
            Integer value = NumAndFre.get(key);//获得频率值
            if(Lists[value]==null){
                Lists[value]=new ArrayList<>();
            }
            Lists[value].add(key);
        }
        //最后是选取  新建一个集合用来保存输出的k个数
        List<Integer> list=new ArrayList<>();
        //因为是出现次数越多，位置就越靠后
        for(int i=Lists.length-1;i>=0&&list.size()<k;i--){
            if(Lists[i]==null){
                continue;
            }
            if(Lists[i].size()<=(k-list.size())){
                list.addAll(Lists[i]);
            }else {
                list.addAll(Lists[i].subList(0,k-list.size()));
            }
        }
        return list;
    }
}

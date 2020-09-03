package 笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 农行 {
       public static String triCoding(int num){
           StringBuilder sb=new StringBuilder();
           List<Integer> list=new ArrayList<>();
           while(num!=0){
               int r=num%3;
               list.add(r);
               num=num/3;
           }
           for(int i=list.size()-1;i>=0;i--){
               switch (list.get(i)){
                   case 0:
                       sb.append("@");
                       break;
                   case 1:
                       sb.append("$");
                       break;
                   case 2:
                       sb.append("&");
                       break;
                   default:
                       break;
               }
           }
           return sb.toString();
       }

    public static void main(String[] args) {
        int num=-1;
        System.out.println(triCoding(num));
    }

}

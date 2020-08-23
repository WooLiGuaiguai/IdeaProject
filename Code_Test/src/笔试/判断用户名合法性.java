package 笔试;

import java.util.Scanner;

public class 判断用户名合法性 {
    public  static String test(int n, String []strings){
        StringBuilder sb=new StringBuilder();
        for (String string : strings) {
            char []chars=string.toCharArray();
            int numofz=0;//字母个数
            int numofs=0;//数字个数
            int count=0;
            boolean flag=false;
            for(int i=0;i<chars.length;i++){
                if(i==0 && !((chars[i]>='A'&& chars[i]<='Z')|| (chars[i]>='a'&&chars[i]<='z'))){
                    sb.append("Wrong\n");
                    flag=true;
                    break;
                }
                //只能保留大小写字母和数字
                if(i!=0 && !((chars[i]>='0' && chars[i]<='9') ||(chars[i]>='A'&& chars[i]<='Z')||(chars[i]>='a'&&chars[i]<='z'))){
                    sb.append("Wrong\n");
                    flag=true;
                    break;
                }
                if((chars[i]>='A'&& chars[i]<='Z')||( chars[i]>='a'&&chars[i]<='z')){
                    numofz++;
                }
                if(chars[i]>='0' && chars[i]<='9'){
                    numofs++;
                }
                count++;
            }
            if(count==string.length() && (numofs<1 || numofz<1)){
                sb.append("Wrong\n");
                flag=true;
                continue;
            }
            if(flag==false){
                sb.append("Accept\n");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String []str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.next();
        }
        System.out.println(test(n,str));
    }
}

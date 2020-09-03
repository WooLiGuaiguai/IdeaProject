package 笔试;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JD {
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> list=new ArrayList<>();
            int temp=sc.nextInt();
            list.add(temp);
            if(temp==1){
                for(int j=0;j<2;j++){
                    list.add(sc.nextInt());
                }
            }else if(temp==2){
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        for(ArrayList<Integer> list:lists){
            if(list.get(0)==1){
                result.add(list.get(1)-1,list.get(2));
            }else if(list.get(0)==2){
                result.remove(list.get(1)-1);
            }else{
                for(Integer integer:result){
                    System.out.print(integer+" ");
                }
            }
        }
    }*/
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();//m个操作
        int []op=new int[m];//存储每个操作的类型
        int [][]add=new int[m][2];//表示插入操作需要两个字符
        int []del=new int[m];
        for(int i=0;i<m;i++){
            op[i]=sc.nextInt();
            switch (op[i]){
                case 1:
                    add[i][0]=sc.nextInt();
                    add[i][1]=sc.nextInt();
                    break;
                case 2:
                    del[i]=sc.nextInt();//表示删除元素的位置
                    break;
                case 3:
                    break;
            }
        }
        List<Integer> list=new ArrayList<>();//存储数据
        int []temp=new int[m];//用来暂存
        //遍历操作集合
        for(int i=0;i<m;i++){
            switch (op[i]){
                case 1:
                    int index=add[i][0]-1;//下标
                    int size=list.size();
                    for(int l=index;l<size;l++){
                        temp[l-index]=list.get(index);
                    }
                    list.add(index,add[i][1]);
                    for(int l=index+1;l<size+1;l++){
                        list.add(l,temp[l-index-1]);
                    }
                    break;
                case 2:
                    int index2=del[i];
                    list.remove(index2);
                    break;
                case 3:
                    for(int k=0;k<list.size();k++){
                        System.out.print(list.get(k));
                    }
                    break;
            }
        }
    }*/

}

/*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();//m个操作
        int []op=new int[m];//存储每个操作的类型
        int [][]add=new int[m][2];//表示插入操作需要两个字符
        int []del=new int[m];
        for(int i=0;i<m;i++){
            op[i]=sc.nextInt();
            switch (op[i]){
                case 1:
                    add[i][0]=sc.nextInt();
                    add[i][1]=sc.nextInt();
                    break;
                case 2:
                    del[i]=sc.nextInt();//表示删除元素的位置
                    break;
                case 3:
                    break;
            }
        }
        int []result=new int[m];//最多有m个数
        //遍历操作集合
        for(int i=0;i<m;i++){
            switch (op[i]){
                case 1:
                    int index=add[i][0]-1;//下标
                    for(int j=m-2;j>=index;j--){
                        result[j+1]=result[j];
                    }
                    result[index]=add[i][1];
                    break;
                case 2:
                    int index2=del[i];
                    for(int j=index2+1;j>=m-1;j++){
                        result[j-1]=result[j];
                    }
                    break;
                case 3:
                    for(int k=0;k<m;k++){
                        System.out.print(result[k]+" ");
                    }
                    break;
            }
        }
    }*/
/*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int number=0;//最后输出的
        while(n!=0){
            number=number*10+n%10;
            n/=10;
        }
        int result=0;
        List<Integer> list=new ArrayList<>();
        while(number!=0){
            int r=number%5;
            list.add(r);
            number=number/5;
        }
        for(int i=list.size()-1;i>=0;i--){
            result=result*10+list.get(i);
        }
        System.out.println(result);
    }*/

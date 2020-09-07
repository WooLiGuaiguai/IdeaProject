package 笔试;

import java.util.*;

public class 鹅厂0906 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->(o1-o2));
            for(int j=0;j<n;j++){
                if(i!=j){
                    queue.add(num[j]);
                }
            }
            for(int j=1;j<=queue.size();j++){
                if(j==n/2){
                    System.out.println(queue.peek());
                    break;
                }
                queue.poll();
            }
        }
    }
}

    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//人数
        int m=sc.nextInt();//团队个数
        int []people=new int[m];//每组的人数
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<m;i++){
            people[i]=sc.nextInt();
            int count=people[i];
            List<Integer> list=new ArrayList<>();
            while(count>0){
                int a=sc.nextInt();
                list.add(a);
                count--;
            }
            lists.add(list);
        }

        //查找人数
        int sum=0;//总人数
        Set<Integer> know=new HashSet<>();
        for(int i=0;i<lists.size();i++){
            if(lists.get(i).contains(0)){
                for(int j=0;j<lists.get(i).size();j++){
                    know.add(lists.get(i).get(j));//把元素添加进来
                }
            }
        }
        for(int i=0;i<lists.size();i++){
            Iterator<Integer> it=know.iterator();
            while(it.hasNext()){
                int num=it.next();
                if(lists.get(i).contains(num)){
                    for(int j=0;j<lists.get(i).size();j++){
                        know.add(lists.get(i).get(j));//把元素添加进来
                    }
                    break;
                }
            }
        }
        System.out.println(know.size());
    }*/


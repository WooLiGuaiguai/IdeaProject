package Ali;

import java.util.Arrays;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int arr[]=new int[n];
            int i=0;
            int m=n;
            while(m>0){
                int num=sc.nextInt();
                arr[i++]=num;
                m--;
            }
            Arrays.sort(arr);
            int []arr2=new int[n];
            if(n%2==0){
                for(int j=0;j<arr.length/2;j++){
                    arr2[j*2]=arr[j];
                }
                for(int j=arr.length-1,t=0;j>=arr.length/2;j--){
                    arr2[2*t+1]=arr[j];
                    t++;
                }
            }else{
                for(int j=0,t=0;j<arr.length/2;j++){
                    arr2[2*t+1]=arr[j];
                    t++;
                }
                for(int j=arr.length-1,t=0;j>=arr.length-2;j--){
                    arr2[t*2]=arr[j];
                    t++;
                }
            }
            int l=arr2[0];
            int sum=0;
            for(int j=1;j<arr2.length;j++){
                sum=sum+(Math.max(l,arr2[j])-Math.min(l,arr2[j]));
                l=arr2[j];
            }
            sum=sum+(Math.max(arr2[arr2.length-1],arr2[0])-Math.min(arr2[arr2.length-1],arr2[0]));
            System.out.println(sum);
        }
    }
}

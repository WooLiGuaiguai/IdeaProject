package Ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ali0415 {
    public static void main(String[] args) {
        /*double[][] Ali.a = {{2, 2}, {3, 1}, {1, 3}};
        System.out.println(maxgra(3, Ali.a));*/
        int num=0;
        Scanner in=new Scanner(System.in);
        num=in.nextInt();
        double [][]gra=new double[num][2];
        for(int i=0;i<num;i++){
            for(int j=0;j<2;j++){
                gra[i][j]=in.nextInt();
            }
        }
        List<Double> list=new ArrayList<>();
        double Min_gra=0;
        for (int i=0;i<gra.length;i++){
            for(int j=0;j<gra.length;j++){
                if(i!=j){
                    double avg_fir=100000000;
                    double avg_sec=100000000;
                    avg_fir=Math.min(avg_fir,(gra[i][0]+gra[j][0])/2);
                    avg_sec=Math.min(avg_sec,(gra[i][1]+gra[j][1])/2);
                    list.add(Math.min(avg_fir,avg_sec));
                }
            }
        }
        Min_gra=list.get(0);
        for(int k=1;k<list.size();k++){
            if(Min_gra<=list.get(k)){
                Min_gra=list.get(k);
            }
        }
        System.out.println(Min_gra);
    }
    public static double maxgra(int num,double [][]gra){
        List<Double> list=new ArrayList<>();
        double Min_gra=0;
        for (int i=0;i<gra.length;i++){
            for(int j=i;j<gra.length;j++){
                double avg_fir=100000000;
                double avg_sec=100000000;
                if(i!=j){
                    avg_fir=Math.min(avg_fir,(gra[i][0]+gra[j][0])/2);
                    avg_sec=Math.min(avg_sec,(gra[i][1]+gra[j][1])/2);
                    list.add(Math.min(avg_fir,avg_sec));
                }
            }
        }
        Min_gra=list.get(0);
        for(int k=1;k<list.size();k++){
            if(Min_gra<=list.get(k)){
                Min_gra=list.get(k);
            }
        }
        return Min_gra;
    }
}

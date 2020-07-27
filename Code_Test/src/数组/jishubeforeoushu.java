package 数组;


import java.util.ArrayList;
/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class jishubeforeoushu {
    public static void main(String[] args) {
        int []a={1,2,3,4,5,6,7,8,9};
        reOrderArray(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    public static void reOrderArray(int [] array){
        //保持相对位置不变 所以只有必须交换的情况下 才要交换
        //也就是两个相邻的如果同为奇数或偶数，索引后移
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2!=0){
                    int temp=0;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    public static void reOrderArray1(int [] array){
        //保持相对位置不变 所以只有必须交换的情况下 才要交换
        //也就是两个相邻的如果同为奇数或偶数，索引后移
        for(int i=0;i<array.length;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]%2!=0&&array[j-1]%2==0){
                    int temp=0;
                    temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
    public static ArrayList<Integer> reOrderArray2(int [] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayList.add(array[i]);
            } else {
                arrayList1.add(array[i]);
            }
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            arrayList.add(arrayList1.get(i));
        }
        return arrayList;
    }

}

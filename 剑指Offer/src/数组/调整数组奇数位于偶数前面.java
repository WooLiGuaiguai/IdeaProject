package 数组;

import java.util.ArrayList;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
// 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class 调整数组奇数位于偶数前面 {
    public static void reOrderArray(int [] array){
        //每次确定最后一个位置的数字  一共遍历array.length次
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0 && array[j+1]%2==1){//前偶后奇时才会交换
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
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
    public static void main(String[] args) {
        int []a={1,2,3,4,5,6,7,8,9};
        reOrderArray(a);
        for (int i : a) {
            System.out.print(i+" ");
        }

        System.out.println();

        int []a1={9,8,7,6,5,4,3,2,1};
        System.out.println(reOrderArray2(a1));
    }
}

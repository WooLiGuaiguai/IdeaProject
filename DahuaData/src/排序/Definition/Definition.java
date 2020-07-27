package 排序.Definition;
//对于数组中的元素交换，可以使用public static void swap(int[] data, int a, int b)方法；
//对于非数组中的元素交换，可以使用数组传值进行数值交换 private static int[] swap(int a, int b)
//也可以使用包装类的方式、外部内联的方式、类变量传值
public class Definition {
    public static void swap(int []data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    private static int[] swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a,b};
    }

}

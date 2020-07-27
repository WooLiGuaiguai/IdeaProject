package cn.ccTengx.day0215;

public class ExceptionTest {
    public static void main(String[] args) {
        int []arr=null;
        int []arr2={1,2,3,4,5};
        //System.out.println(show1(arr,1));
        System.out.println(show1(arr2,5));
    }
    public static int show1(int [] arr,int index){
        if(arr==null){
            throw new NullPointerException("空指针异常");
        }
        if(index<0||index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("越界异常");
        }
        return arr[index];
    }
}

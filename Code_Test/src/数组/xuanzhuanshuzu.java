package 数组;
//旋转数组最小数字
public class xuanzhuanshuzu {
    //数组不管是否旋转，每部分肯定都是非递减的
    //所以使用中间值来进行比较

    public static void main(String[] args) {
        int []a={3,4,5,1,2};
        System.out.println(get(a));
    }
    public static int get(int []array){
        if(array.length==0||array==null){
            return 0;
        }
        int left=0,right=array.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(array[mid]<array[right]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return array[right];
    }

}

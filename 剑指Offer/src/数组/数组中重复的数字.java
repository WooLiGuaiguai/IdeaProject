package 数组;
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的
// 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
// 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
public class 数组中重复的数字 {
    public boolean duplicate(int numbers[],int length,int [] duplication){
        //创建一个数组，通过把每个数字放在和自己相同的下标上，可以判断重复
        if(numbers==null||numbers.length==0){
            return false;
        }
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){//number[2]=10  number[number[2]]=number[10]
                    duplication[0]=numbers[i];
                    System.out.println(duplication[0]);
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    public void swap(int []numbers,int i,int j){
        int temp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }

    public static void main(String[] args) {
        int []arr={2,3,1,0,2,5,3};
        数组中重复的数字 a=new 数组中重复的数字();
        System.out.println(a.duplicate(arr,7,new int[1]));
    }
}

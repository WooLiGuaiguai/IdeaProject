package 数组;
/*在一个二维数组中每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数*/

public class 二维数组查找 {
    public static boolean Find(int target, int [][] array){
        if(array==null){
            return false;
        }
        //从左下角开始
        int i=array.length-1,j=0;//遍历开始坐标
        while(i>=0 && j<=array[0].length-1){
            if(array[i][j]==target){
                return true;
            }else if(array[i][j]<target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]arr={{1,2,3,4},{4,5,6,7},{7,8,9,10},{15,16,47,49}};
        System.out.println(Find(37,arr));
    }
}

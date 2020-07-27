package 数组;

public class erwei_chazhao {
    /*1.在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/
    public static void main(String[] args) {
        int [][]arr={{1,2,3,4},{4,5,6,7},{7,8,9,10},{15,16,47,49}};
        System.out.println(Find(10,arr));
    }
    public static  boolean Find(int target, int [][] array){
        //从左下角开始  数组的长度是属性
        int i=array.length-1,j=0;
        while(i>=0&&j<array[0].length){
            if(target>array[i][j]){
                j++;
            }
            else if(target<array[i][j]){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }
}

package 贪心算法;

public class GA5 {
    public static void main(String[] args) {
        int []a={1,0,0,0,0,0,1};
        //System.out.println(canPlaceFlowers(Ali.a,1));
        System.out.println(canPlaceFlowers(a,2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        int index=0;
        int count=0;
        while(index<flowerbed.length){
            if(flowerbed[index]==0&&(index==0||flowerbed[index-1]==0)&&(index==flowerbed.length-1||flowerbed[index+1]==0)){
                flowerbed[index]=1;
                count++;
            }
            if(count>=n){
                return true;
            }
            index++;
        }
        return false;
    }
}

package 位运算;

public class 求补码 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
    public static int findComplement(int num) {
        if(num==0){
            return 1;
        }
        int mask=1;
        mask=mask<<30;
        while((mask&num)==0){
            mask=mask>>1;
        }
        mask=(mask<<1)-1;//00000100--00001000--00000111
        return num^mask;
    }
}

package 位运算;

import java.util.HashMap;

public class 翻转一个数的比特位 {
    public static void main(String[] args) {
        int n=43261596;
        System.out.println(reverseBits(n));
    }
    //考虑如果这个数的比特位很多 也就是翻转函数需要多次调用，我们将int转化成4byte来计算
    private static HashMap<Byte,Integer>cache=new HashMap<>();//存储每个byte翻转之后的结果，如果存在byte翻转前相同的就不用再次计算了
    public static int reverseBits(int n){
        int ans=0;//暂时保留翻转之后的结果
        for(int i=0;i<4;i++){
            ans<<=8;//每一运算是一个字节 8位，所以需要向左移动8位，为保留后面一个字节翻转的结果腾地方
            ans|=reverseByte((byte)(n&0b11111111));//0b表示后面是二进制数字 也就是截了n末尾8位进行翻转
            n>>>=8;//把后八位删除掉
        }
        return ans;
    }
    public static int reverseByte(byte b){
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        int ans=0;
        byte t=b;
        for(int i=0;i<8;i++){
            ans<<=1;
            ans|=t&1;
            t>>>=1;
        }
        cache.put(b,ans);
        return ans;
    }
}

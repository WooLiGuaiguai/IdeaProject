package 递归问题;
//f(n−1,m) 表示的是 n−1个人报数，每报到 m 的人出列，最后出列的人的编号：
//f(n,m)=(f(n−1,m)+m)%n
//f(n−1,m) 表示的是总人数为 n - 1 个时，最后出列的人的编号，假如暂不考虑数组越界的问题，
//那么当总人数为 n 时，最后出列的人的编号就是 f(n−1,m)+m，为了防止数组越界，对 n 取余数
public class 约瑟夫环 {
    public static int YueSeFu(int n,int m){//n代表的是总人数  m代表的是每次被晒出来的排名
        if(n==1){
            return 1;
        }
        //如果编号从0开始计算  返回下标 0
        //return (YueSeFu(n-1,m)+m)%n;
        //如果编号从1开始计算   返回的是下标
        return (YueSeFu(n-1,m)+m-1)%n+1;
    }

    public static void main(String[] args) {
        System.out.println(YueSeFu(6,3));
    }
}

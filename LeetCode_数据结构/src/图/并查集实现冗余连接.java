package 图;
//输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成
//附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
//输入图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
//返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
//输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
//
public class 并查集实现冗余连接 {
    public static void main(String[] args) {

    }
    //并查集可以动态地连通两个点，并且可以非常快速地判断两个点是否连通。
    int[] f;
    boolean union(int a,int b){
        int n=0;
        //找a的父级
        while(a!=f[a]){
            a=f[a];
            n++;
        }
        //找b的父级
        while(b!=f[b]){
            b=f[b];
            n--;
        }
        //如果相等，就可以跳出了，
        if(a==b){
            return false;
        }
        //不相等，n>0说明a的深度高，就把a给f[b]
        //反之，b的深度高，就把b给f[a]
        if(n>0){
            f[b]=a;
        }else{
            f[a]=b;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        f=new int[edges.length+1];
        for(int i=0;i<f.length;i++){
            f[i]=i;
        }
        for(int[] e:edges){
            if(!union(e[0],e[1])){
                return e;
            }
        }
        return new int[]{};
    }
}

package Util;
//（1）张无忌和杨过打架之前，先判断是否是同一门派，这就涉及到了并查集的查找操作。
//
//（2）张无忌和杨过觉得俩人合得来，那就合并门派，这就涉及到了并查集的合并操作。
//
//（3）每一个门派都有一个掌门人，这涉及到了并查集的存储方式。掌门人代表了这个门派的根节点。
public class Union_find {
    private int []root;//创建一个数组保存每个分集的根结点（合并门派时的掌门）
    Union_find(int number){//初始化数组 每个人最开始都是自成一派
        root = new int[number + 1];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }
    //合并的时候，判断一下root1和root2谁的子节点多，谁多谁做上级领导。防止一条链过长，向上查找很繁琐
    public boolean union(int root1,int root2){
        int n=0;
        //找root1的父级
        while(root1!=root[root1]){
            root1=root[root1];
            n++;
        }
        //找root2的父级
        while(root2!=root[root2]){
            root2=root[root2];
            n--;
        }
        //如果相等，就可以跳出了，
        if(root1==root2){
            return false;
        }
        //不相等，n>0说明root1的深度高，就把root1给f[root2]
        //反之，root2的深度高，就把root2给f[root1]
        if(n>0){
            root[root2]=root1;
        }else{
            root[root1]=root2;
        }
        return true;
    }
}

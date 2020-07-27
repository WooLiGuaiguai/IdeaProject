package 图;

import java.util.ArrayList;
import java.util.List;

/*这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
示例 1:
输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
*/
public class 实现课程安排 {
    //其实就是判断有没有环路出现
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //设置一个数组 每个元素是一个集合盛放 完成课程i需要的其他课程
        List<Integer>[] graphic=new List[numCourses];
        for (int i = 0; i < graphic.length; i++) {
            graphic[i]=new ArrayList<>();
        }
        //把这些课程添加进来  每行是一个元素
        for(int []preCourse:prerequisites){
            graphic[preCourse[0]].add(preCourse[1]);
        }
        boolean []global=new boolean[numCourses];//用来判断是否是环路
        boolean []local=new boolean[numCourses];//
        for(int i=0;i<numCourses;i++){
            if(isCircle(global,local,graphic,i)){
                return false;
            }
        }
        return true;
    }
    public boolean isCircle(boolean []global,boolean []local,List<Integer>[] graphic,int curnode){
        if(global[curnode]){
            return true;
        }
        if(local[curnode]){
            return false;
        }
        global[curnode]=true;
        local[curnode]=true;
        for(int nextNode:graphic[curnode]){
            if(isCircle(global,local,graphic,nextNode)){
                return true;
            }
        }
        global[curnode]=false;
        return false;
    }
}

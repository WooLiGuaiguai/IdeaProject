package 图;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
*/
public class 课程安排的顺序_拓扑 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic=new List[numCourses];
        for(int i=0;i<graphic.length;i++){
            graphic[i]=new ArrayList<>();
        }
        for (int[] preCourse : prerequisites) {
            graphic[preCourse[0]].add(preCourse[1]);
        }
        Stack<Integer>stack=new Stack<>();
        boolean []global=new boolean[numCourses];//表示是否正在被访问
        boolean []local=new boolean[numCourses];//表示是否被访问过
        for(int i=0;i<numCourses;i++){
            if(isCircle(global,local,graphic,i,stack)){
                return new int[0];
            }
        }
        int []order=new int[numCourses];
        for(int i=numCourses-1;i>=0;i--){
            order[i]=stack.pop();
        }
        return order;
    }
    public boolean isCircle(boolean []global,boolean []local,List<Integer>[] graphic,int CurNode,Stack<Integer>stack){
        if(global[CurNode]){//正在被访问的话 说明是环
            return true;
        }
        if(local[CurNode]){//已经被访问过
            return false;
        }
        global[CurNode]=true;
        local[CurNode]=true;
        for(int NextNode:graphic[CurNode]){
            if(isCircle(global,local,graphic,NextNode,stack)){
                return true;
            }
        }
        global[CurNode]=false;//该点结束访问
        stack.push(CurNode);
        return false;
    }
}

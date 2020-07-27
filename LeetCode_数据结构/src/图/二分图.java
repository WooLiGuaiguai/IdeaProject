package 图;

import java.util.Arrays;
import java.util.Stack;

/*给定一个无向图graph，当这个图为二分图时返回true。
如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
*/
public class 二分图 {
    public static void main(String[] args) {

    }
    public static boolean isBipartite(int[][] graph) {
        int num=graph.length;
        int []colors=new int[num];
        Arrays.fill(colors,-1);
        for(int i=0;i<num;i++){
            if(colors[i]==-1){
                Stack<Integer> stack=new Stack<>();
                stack.push(i);
                colors[i]=0;//标记被访问上了颜色
                while(!stack.isEmpty()){
                    Integer item=stack.pop();
                    for(int nextitem:graph[item]){
                        if(colors[nextitem]==-1){
                            stack.push(nextitem);
                            colors[nextitem]=colors[item]^1;
                        }else if(colors[nextitem]==colors[item]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

package 搜索.BFS;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典中的单词。
//说明:
//如果不存在这样的转换序列，返回 0。
//所有单词具有相同的长度。
//所有单词只由小写字母组成。
//字典中不存在重复的单词。

import java.util.*;

//输入:
//beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//输出: 5
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
public class 单词接龙 {
    public static void main(String[] args) {
        String str1="hit";
        String str2="cog";
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(str1,str2,wordList));
    }
    //首先考虑的是使用图来进行判断，这里想要解决的问题是可达性问题
    //判断两个结点之间是否相连接是判断两个节点是否只有一个字母不相同
    //将一个点的可达结点存储到一个集合中，所有的集合组成了一个图
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int n=wordList.size();
        int startindex=n-1;//初始字母的下标
        int endindex=0;//最终字母的下标
        while(endindex<n && !wordList.get(endindex).equals(endWord)){
            endindex++;
        }
        if(endindex==n){
            return 0;//没有找到不可达
        }
        //如果可以找到这个字符串 那么构建成一个图
        List<Integer>[] graphic=graphic_build(wordList);
        return BFS(graphic,startindex,endindex);//判断从起始坐标 到最终坐标是否可达
    }
    public static List<Integer>[] graphic_build(List<String> wordList){
        int size=wordList.size();
        List<Integer>[] graphic=new List[size];
        for(int i=0;i<size;i++){
            graphic[i]=new ArrayList<>();
            for(int j=0;j<size;j++){
                if(isConnected(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);//
                }
            }
        }
        return graphic;
    }
    //判断是否连接
    public static boolean isConnected(String str1,String str2){
        int diff=0;
        for(int i=0;i<str1.length() && diff<=1;i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }
    //BFS开始遍历是否可达  可达长度是多少
    public static int BFS(List<Integer>[] graphic,int startindex,int endindex){
        Queue<Integer>queue=new LinkedList<>();
        boolean[] flag=new boolean[graphic.length];
        queue.add(startindex);
        int level=1;//最后返回的长度
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            while(size-->0){
                int index=queue.poll();
                //遍历它的可达性集合，将他们入队列
                for (int nextIndex : graphic[index]) {
                    if(nextIndex==endindex){
                        return level;
                    }
                    if(flag[nextIndex]){
                        continue;
                    }
                    flag[nextIndex]=true;
                    queue.add(nextIndex);
                }
            }
        }
        return 0;
    }
}

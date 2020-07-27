package 搜索.回溯;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//说明: 叶子节点是指没有子节点的节点。
//输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    public static void main(String[] args) {

    }
    public static List<String> binaryTreePaths(TreeNode root){
        List<String>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> pathList=new ArrayList<>();//先将路径以数字的形式存储在集合中，然后将每个集合转化成字符串存储到String集合
        Back_findPath(list,pathList,root);
        return list;
    }
    public static void Back_findPath(List<String>list,List<Integer> pathList,TreeNode root){
        if(root==null){
            return;
        }
        pathList.add(root.val);
        if (root.left == null && root.right == null) {//表示遍历到叶子结点
            list.add(BuildPath(pathList));
        }else{
            Back_findPath(list,pathList,root.left);
            Back_findPath(list,pathList,root.right);
        }
        pathList.remove(pathList.size()-1);
    }
    public static String BuildPath(List<Integer> pathList){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<pathList.size();i++) {
            sb.append(pathList.get(i));
            if(i!=pathList.size()-1){
                sb.append("->");
            }
        }
        return sb.toString();
    }
}

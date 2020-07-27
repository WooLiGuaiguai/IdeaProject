package 树;

import java.util.TreeMap;
//字典树
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;//存放下一个结点的引用

        public Node(){
            this.isWord=false;
            this.next=new TreeMap<>();
        }
        public Node(boolean isWord){
            this.isWord=isWord;
            this.next=new TreeMap<>();
        }
    }

    private Node root;
    private int size;
    public Trie(){
        this.root=new Node();
        this.size=0;
    }
    //返回树中结点个数
    public int getSize() {
        return size;
    }

    //字典树的操作函数：
    //1.插入操作
    public void add(String word){
        Node cur=root;//用来向下移动
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);//获取每个字符
            if(cur.next.get(ch)==null){//如果在他的next集合中找不到字符 说明没有 创建
                cur.next.put(ch,new Node());
            }
            cur=cur.next.get(ch);//如果找到了 cur向下移动  继续查找
        }
        if(!cur.isWord){//如果之前不是单词 那么设为true
            cur.isWord=true;
            size++;
        }
    }
    //2.查找操作
    public boolean search(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.next.get(ch)==null){
                return false;
            }
            cur=cur.next.get(ch);
        }
        return cur.isWord;
    }
    //3.判断是否在字典树中有意该字符串为前缀的单词
    public boolean isPrefix(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(cur.next.get(ch)==null){
                return false;
            }
            cur=cur.next.get(ch);
        }
        return true;
    }
    //4. 删除操作
    //需要考虑三种情况：1.被删除的单词是另一个单词的前缀   2.被删除的单词的所有字母都没有分支
    //                  3.被删除的单词除了最后一个字母，其他字母还有许多分支
    public boolean delete(String word){
        Node multiChildNode = null;
        int multiChildNodeIndex = -1;
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.next.get(ch)==null){//不存在这个单词
                return false;
            }
            //当前结点的子节点大于1个
            if(cur.next.get(ch).next.size()>1){
                multiChildNodeIndex=i;
                multiChildNode=cur.next.get(ch);
            }
            cur=cur.next.get(ch);
        }
        //如果被删除的word最后一位cur后面还有结点
        if(cur.next.size()>0){//符合情况1  只需要判断是否存在该单词 存在的话将isWord重置
            if(cur.isWord){
                cur.isWord=false;
                size--;
                return true;//存在 删除成功 返回true
            }
            return false;//不存在 返回false
        }
        //如果单词的所有字母都没有分支，删除整个单词
        if(multiChildNodeIndex==-1){
            root.next.remove(word.charAt(0));
            size--;
            return true;
        }
        //如果单词除了最后一个字母,其他字母存在分支
        if(multiChildNodeIndex!=word.length()-1){
            multiChildNode.next.remove(word.charAt(multiChildNodeIndex+1));
            size--;
            return true;
        }
        return false;
    }
}

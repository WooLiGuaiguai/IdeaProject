package 树;

import java.util.HashMap;
import java.util.Map;

public class TrieSum {
    public static void main(String[] args) {
        TrieSum trieSum1=new TrieSum();
        trieSum1.insert("apple",3);
        System.out.println(trieSum1.sum("ap"));
        trieSum1.insert("app",2);
        System.out.println(trieSum1.sum("ap"));
    }
    public class Node{
        public int value;
        public Map<Character,Node> next;

        public Node(int value){
            this.value=value;
            this.next=new HashMap<>();
        }
        public Node(){
            this.next=new HashMap<>();
        }

    }
    public Node root;

    public TrieSum(){
        this.root=new Node();
    }
    public void insert(String word,int val){
        Node cur=root;//用来向下移动
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);//获取每个字符
            if(cur.next.get(ch)==null){//如果在他的next集合中找不到字符 说明没有 创建
                cur.next.put(ch,new Node());
            }
            cur=cur.next.get(ch);//如果找到了 cur向下移动  继续查找
        }
        cur.value=val;
    }
    public int sum(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(cur.next.get(ch)==null){
                return 0;
            }
            cur=cur.next.get(ch);
        }
        return count(cur);
    }
    //cur指向prefix的最后一个字符的Node
    //对每个以prefix为前缀的node进行累加
    public int count(Node root){
        int result=root.value;
        for(char ch:root.next.keySet()){//找到它对应的next中的所有key
            result=result+count(root.next.get(ch));
        }
        return result;
    }
}

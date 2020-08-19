package 字符串;

import java.util.LinkedList;
import java.util.Queue;
//请实现一个函数用来找出字符流中第一个只出现一次的字符。
//例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
//当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
public class 字符流中第一个只出现一次的字符 {
    //首先用数组保存每个字符出现的频数
    //其次使用一个队列保存出现的字符，出现次数大于1并且位于队首的话出队列，最后只返回第一个就是第一次出现的
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        queue.add(ch);
        cnts[ch]++;
        while (!queue.isEmpty() && cnts[queue.peek()] > 1){
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static void main(String[] args) {
        字符流中第一个只出现一次的字符 a=new 字符流中第一个只出现一次的字符();
        String str="google";
        char []chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            a.Insert(chars[i]);
            System.out.print(a.FirstAppearingOnce()+" ");
        }
    }
}

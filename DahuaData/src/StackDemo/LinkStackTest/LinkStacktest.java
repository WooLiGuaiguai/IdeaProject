package StackDemo.LinkStackTest;

public class LinkStacktest {
    public static void main(String[] args) {
        LinkStack<String>stack=new LinkStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println("打印当前栈"+stack);
        System.out.println("取出栈顶"+stack.pop());
        System.out.println("输出栈顶"+stack.peek());
        System.out.println("输出长度"+stack.length());
        stack.clear();
        System.out.println(stack);
    }
}

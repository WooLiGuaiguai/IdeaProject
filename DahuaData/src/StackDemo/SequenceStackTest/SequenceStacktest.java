package StackDemo.SequenceStackTest;

public class SequenceStacktest {
    public static void main(String[] args) {
        SequenceStack<Integer> stack=new SequenceStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("打印栈：");
        System.out.println(stack);
        System.out.println("判断是否为空");
        System.out.println(stack.isEmpty());
        System.out.println("取出栈顶元素：");
        System.out.println(stack.peek());
        System.out.println("出栈:");
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println("清空栈：");
        stack.clear();
        System.out.println(stack);

    }
}

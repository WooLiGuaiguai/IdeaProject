package StackDemo.LinkStackTest;

import StackDemo.Stack;
//使用链表实现栈
public class LinkStack<E> implements Stack<E> {

    private static class Node<E>{
        E item;
        Node<E> next;
        public Node(){
        }
        public Node(E item,Node<E>next){
            this.item=item;
            this.next=next;
        }
    }
    //当前栈内元素个数
    private int size;
    //栈顶
    private Node<E> top;
    //初始化栈
    public LinkStack() {
        top = null;
        size = 0;
    }
    //以默认元素来构建栈
    public LinkStack(E data) {
        this();
        Node<E> newNode = new Node<>(data, null);
        newNode.next = top;
        top = newNode;
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void push(E data) {
        Node<E> node=new Node<>(data,null);
        node.next=top;
        top=node;
        size++;
    }

    @Override
    public E pop() {
        checkIsEmpty();
        Node<E> node=top;//将栈顶元素赋值给一个新的结点
        top=top.next;//移动top指针
        node.next=null;//删除栈顶元素
        size--;
        return node.item;
    }

    @Override
    public E peek() {
        checkIsEmpty();
        return top.item;
    }

    @Override
    public void clear() {
        for (Node<E> node = top; node != null; ) {
            Node<E> next = node.next;
            node.item = null;
            node = next;
        }
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("当前栈为空");
        }
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder sb=new StringBuilder("[");
            Node<E> node=new Node<>();
            for(node=top;node.next!=null;node=node.next){
                sb.append(node.item.toString()+",");
            }
            sb.append(node.item.toString()+"]");
            return sb.toString();
        }
    }
}

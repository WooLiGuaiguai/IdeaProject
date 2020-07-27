package StackDemo.SequenceStackTest;

import StackDemo.Stack;

import java.util.Arrays;

//使用数组实现栈
public class SequenceStack<E> implements Stack<E> {
    //默认长度
    private static int DEFAULT_SIZE = 10;
    //当前栈内元素个数
    private int size = 0;
    //数组的长度
    private int capacity;
    //保存栈内元素的数组
    private Object[] elementData;
    //初始化数组
    public SequenceStack(){
        this.capacity=DEFAULT_SIZE;
        elementData=new Object[capacity];
    }
    //指定长度初始化数组
    public SequenceStack(int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    //入栈
    @Override
    public void push(E data) {
        checkIsFull();
        elementData[size++]=data;//一开始size=0
    }
    //出栈
    @Override
    public E pop() {
        checkIsEmpty();
        E e=(E) elementData[size-1];
        elementData[--size]=null;
        return e;
    }
    //取栈顶元素
    @Override
    public E peek() {
        checkIsEmpty();
        E e=(E) elementData[size-1];
        return e;
    }
    //清空栈
    @Override
    public void clear() {
        Arrays.fill(elementData,null);
        size=0;
    }

    @Override
    public int length() {
        return size;
    }
    //栈满抛出异常
    private void checkIsFull(){
        if(size==capacity-1){
            throw new IndexOutOfBoundsException("栈满");
        }
    }
    //若栈空则抛出异常
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈是空的");
        }
    }

    @Override
    public String toString() {
        if(size==0){
            return "[]";
        }else{
            StringBuilder sb=new StringBuilder("[");
            for(int i=size-1;i>0;i--){
                sb.append(elementData[i].toString()+",");
            }
            sb.append(elementData[0].toString());
            return sb.append("]").toString();
        }
    }
}

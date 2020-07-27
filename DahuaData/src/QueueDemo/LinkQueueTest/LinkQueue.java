package QueueDemo.LinkQueueTest;

import QueueDemo.Queue;

public class LinkQueue<E>implements Queue<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        public Node() {
        }
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    //队列包含的结点数
    private int size;


    public LinkQueue() {
        front = null;
        rear = null;
    }

    //以特定的数据来构造链表队列的头结点
    public LinkQueue(E data) {
        front = new Node<>(data, null);
        rear = front;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    @Override
    public void push(E data) {
        Node<E> newNode = new Node<>(data, null);
        // 当前队列为空
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // 队列存在元素
            // 尾结点的next指向新结点
            rear.next = newNode;
            // 新结点成为新的尾结点
            rear = newNode;
        }
        size++;
    }

    //出队，并删除头元素

    @Override
    public E pop() {
        // 检测队列是否空
        checkQueueIsEmpty();
        Node<E> oldFront = front;
        front = front.next;
        oldFront.next = null;
        size--;
        return oldFront.item;
    }

    //查找队列的front元素
    @Override
    public E peek() {
        // 检测队列是否空
        checkQueueIsEmpty();
        return front.item;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * 返回队列长度
     *
     * @return
     */
    @Override
    public int length() {
        return size;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node<E> cur = front; cur != null; cur = cur.next) {
                sb.append(cur.item.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    /**
     * 判断队列是否为空，若为空则抛出IndexOutOfBoundsException
     */
    private void checkQueueIsEmpty() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }

    }
}

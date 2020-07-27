package QueueDemo;

public interface Queue<E> {
    boolean isEmpty();
    void push(E data);
    E pop();
    E peek();
    void clear();
    int length();
}

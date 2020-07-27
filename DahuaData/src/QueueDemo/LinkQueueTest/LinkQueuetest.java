package QueueDemo.LinkQueueTest;

public class LinkQueuetest {
    public static void main(String[] args) {

        LinkQueue<Integer> queue = new LinkQueue<>();
        // 添加两个元素
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("打印队列:" + queue);
        // 删除一个元素
        System.out.println("删除一个元素，该元素为:" + queue.pop());
        System.out.println("删除一个元素后的队列:" + queue);
        // 输出当前队列的第一个元素
        System.out.println("输出当前队列的第一个元素:" + queue.peek());
        System.out.println("打印队列:" + queue);
    }
}

package interview.exam;

import java.util.Queue;

/**
 * @author Zero
 * @date 2023/2/12 19:55
 * @description
 * @since 1.8
 **/
public class Consumer {
    Queue<Integer> queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public synchronized Integer removeObject() throws InterruptedException {
        while(queue.size() <= 0) {
            wait();
        }
        Integer e = queue.poll();
        notifyAll();
        System.out.println("消费线程，当前队列的大小是" + queue.size());
        return e;
    }
}

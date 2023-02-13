package interview.exam;

import java.util.Queue;

/**
 * @author Zero
 * @date 2023/2/12 19:55
 * @description
 * @since 1.8
 **/
public class Producer {
    Queue<Integer> queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public synchronized void addObject(int val) throws InterruptedException {
        while(queue.size() > 10) {
            wait();
        }
        queue.add(val);
        notifyAll();
        System.out.println("生产线程，当前队列的大小是" + queue.size());
    }
}

package interview.exam;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zero
 * @date 2023/2/12 19:55
 * @description
 * @since 1.8
 **/
public class Test {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("生产了数据" + i);
                    producer.addObject(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    final Integer integer = consumer.removeObject();
                    System.out.println("消费了数据" + integer);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }


}

package interview;

/**
 * @author Zero
 * @date 2022/3/25 12:59
 * @description
 * @since 1.8
 **/
public class ABC问题 {
    private int index = 0;
    public synchronized void printA() throws InterruptedException {
        //wait（）有虚假唤醒问题，所以要用while
        while(index != 0) {
            wait();
        }
        index = (index + 1) % 3;
        System.out.println("A");
        notifyAll();
    }

    public synchronized void printB() throws InterruptedException {
        //wait（）有虚假唤醒问题，所以要用while
        while(index != 1) {
            wait();
        }
        index = (index + 1) % 3;
        System.out.println("B");
        notifyAll();
    }

    public synchronized void printC() throws InterruptedException {
        //wait（）有虚假唤醒问题，所以要用while
        while(index != 2) {
            wait();
        }
        index = (index + 1) % 3;
        System.out.println("C");
        notifyAll();
    }

    public static void main(String[] args) {
         ABC问题 pa = new ABC问题();
         new Thread(() -> {
             for(int i = 0; i < 10; i++) {
                 try {
                     pa.printA();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }).start();

         new Thread(() -> {
             for(int i = 0; i < 10; i++) {
                 try {
                     pa.printC();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }).start();

         new Thread(() -> {
             for(int i = 0; i < 10; i++) {
                 try {
                     pa.printB();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }).start();
    }

}

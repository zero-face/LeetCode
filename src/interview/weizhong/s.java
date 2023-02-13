package interview.weizhong;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/13 20:32
 * @description
 * @since 1.8
 **/
public class s {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t  = in.nextInt();
        in.nextLine();
        while(t-- > 0) {
            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(m);
            bfs(queue, m, n);
            System.out.println(res);
        }
    }
    private static void bfs(Queue<Integer> queue, int m, int n) {
        while(!queue.isEmpty()) {
            int len = queue.size();
            if(queue.contains(n)) {
                return;
            }
            boolean flag = false;
            for(int i = 0; i < len; i++) {
                int t = queue.poll();
                if(t == n) {
                    flag = true;
                    break;
                }
                queue.add(t * 2);
                queue.add(t * 4);
                queue.add(t * 8);
                if(t % 8 == 0) {
                    queue.add(t / 8);
                }
                if(t % 4 == 0) {
                    queue.add(t / 4);
                }
                if(t % 2 == 0) {
                    queue.add(t / 2);
                }
            }
            res++;
        }
        res = -1;
    }
}

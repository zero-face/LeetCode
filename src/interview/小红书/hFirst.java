package interview.小红书;
import java.util.*;

/**
 * @author Zero
 * @date 2022/9/4 16:26
 * @description
 * @since 1.8
 **/
public class hFirst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        int h = k % (2 * n);
        int p = 0;
        if(h % n == 0 && h / n == 1) {
            p = 1;
            h = n - p;
        } else if(h > n) {
            p = h - n;
            h = n - p;
        } else {
            System.out.println(ints[h - 1]);
            return;
        }

        System.out.println(ints[h]);
    }
}

package interview.ouke;

import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/16 14:31
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        int min = ints[0];
        int res = 0;
        int ans = 0;
        for(int i = 1; i < ints.length; i++) {
            res = Math.max(res,Math.max(0, ints[i] - min));
            if(ints[i] < min) {
                min = ints[i];
                ans += res;
                res = 0;
                k--;
            }
            if(k <= 0) {
                break;
            }
        }
        ans += res;
        System.out.println(ans);
    }
}

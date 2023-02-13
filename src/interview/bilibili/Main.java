package interview.bilibili;

/**
 * @author Zero
 * @date 2022/9/1 19:52
 * @description
 * @since 1.8
 **/
import java.util.*;

// 一个数因数的和最小
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int res = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                }

            }
        }
        System.out.println(dp[n]);
    }
}

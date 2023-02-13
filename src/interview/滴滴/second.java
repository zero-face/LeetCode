package interview.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/4 19:53
 * @description
 * @since 1.8
 **/
public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();
        int[] l = new int[k];
        int[] r = new int[k];
        int[] t = new int[k];
        for(int i = 0; i < k; i++) {
            l[i] = in.nextInt();
        }
        in.nextLine();
        for(int i = 0; i < k; i++) {
            r[i] = in.nextInt();
        }
        in.nextLine();
        for(int i = 0; i < k; i++) {
            t[i] = in.nextInt();
        }
        int[] dp = new int[70000];
        Arrays.fill(dp,-1);
        for(int i = 0; i < k; i++) {
            int intl = l[i];
            int intr = r[i];
            int intt = t[i];
            int count = 0;
            while(intl <= intr) {
                int ans = 0;
                if(dp[intl] > 0) {
                    ans = dp[intl];
                } else {
                    ans = yh(intl);
                    dp[intl] = ans;
                }
                if(ans == intt) {
                    count++;
                }
                intl++;
            }
            System.out.print(count + " ");
        }
    }

    private static int yh(int intl) {
        if(intl < 10) {
            return intl;
        }
        int count = 0;
        while(intl != 0) {
            int k = intl % 10;
            intl /= 10;
            count ^= k;
        }
        return count;
    }
}

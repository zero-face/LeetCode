package codetop;

/**
 * @author Zero
 * @date 2022/8/25 16:27
 * @description
 * @since 1.8
 **/
public class 圆环回原点问题 {
    public int backToPoint(int length) {
        int[][] dp = new int[10][10];
        dp[0][0] = 1;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length)%length] + dp[j - 1][(j + 1) % length];
            }
        }
        return dp[length - 1][0];
    }
}

package codetop;

/**
 * @author Zero
 * @date 2022/3/28 9:48
 * @description
 * @since 1.8
 **/
public class 最长公共子序列 {
    //二维动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp表示0 - i和0 - j的最长公共子序列（i, j都不能等于0，因为长度为0的字符串没有公共子序列）
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                //当两个结尾字符相等，那么就是长度减一的两字符串公共子序列长度 + 1；否则就是上一个长度减一字符串中较大的那个
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

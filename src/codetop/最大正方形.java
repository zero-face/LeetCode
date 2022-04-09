package codetop;

/**
 * @author Zero
 * @date 2022/3/28 9:29
 * @description 两种方法：位运算，动态规划
 * @since 1.8
 **/
public class 最大正方形 {
    /**
     * 动态规划
     * 以i,j所在位置为右下角，那么最大的正方形就是左上角，上，左边三个最大正方形中最小的那个+1；前提是当前位置为1，特殊情况是i=0或者j=0,最大都是1
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    /**
     * 位运算
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            char[] bin = matrix[i];
            //这里要从当前行开始与，因为单个字符也算一个正方形
            for (int j = i; j < n; j++) {
                bin = and(bin, matrix[j]);
                //宽度是连续的1的个数
                int width = width(bin);
                //高度就是起始到目前的高度
                int height = j - i + 1;
                //长度和宽度中较小的那个就是正方形的边长
                maxSize = Math.max(maxSize, Math.min(width, height));
                //当宽度比长度还要小的时候，那么正方形就不可能再大，高度增加也没用，就直接break
                if(width <= height) {
                    break;
                }
            }
        }
        return maxSize * maxSize;
    }

    //计算出字符数组中最长的连续1的个数
    private int width(char[] bin) {
        int width = 0;
        int persist = 0;
        for (int i = 0; i < bin.length; ++i) {
            if(bin[i] == '1') {
                persist++;
            } else {
                width = Math.max(width, persist);
                persist = 0;
            }
        }
        width = Math.max(width, persist);
        return width;
    }
    //两个字符数组进行与运算
    private char[] and(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if(b[i] == '0') {
                a[i] = '0';
            }
        }
        return a;
    }
}

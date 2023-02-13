package interview.pinduoduo;

import java.util.*;

/**
 * @author Zero
 * @date 2022/9/3 15:47
 * @description
 * 1
 * 3
 * L 1
 * L 1
 * R 1
 *
 * 1
 * 4
 * R 1
 * L 1
 * L 1
 * R 100
 * @since 1.8
 **/
public class second {

// 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while(t-- > 0) {
            int n = in.nextInt();
            in.nextLine();
            String[][] str = new String[n][2];
            for(int i = 0; i < n; i++) {
                String s = in.nextLine();
                String[] s1 = s.split(" ");
                for(int j = 0; j < 2; j++) {
                    str[i][j] = s1[j];
                }
            }
            int[] dp = new int[n];
            for(int i = 0; i < n; i++) {
                Set<Integer> list = new HashSet<>();
                int num = 0;
                num = dfs(i , dp, num, str, list);
                if(num < 0) {
                    dp[i] = -1;
                } else {
                    dp[i]= num;
                }

            }
            for(int i = 0; i < n; i++) {
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
    }

    public static int dfs(int i, int[] dp, int num, String[][] str, Set<Integer> list) {
        if(i < 0 || i >= str.length) {
            return 0 ;
        }
        if(dp[i] > 0) {
            num = dp[i];
            return num;
        }
        if(!list.add(i) || dp[i] < 0) {
            return -1000;
        }
        int k = Integer.valueOf(str[i][1]);
        if(str[i][0].equals("L")) {
            i = i - k;
        } else {
            i = i + k;
        }
        return 1 + dfs(i, dp, num, str, list);
    }

}

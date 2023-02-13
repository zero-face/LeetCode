package interview.美团笔试;

import java.util.*;

/**
 * @author Zero
 * @date 2022/8/27 16:55
 * @description
 * @since 1.8
 **/
public class Third {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int[] gueLen = new int[m];
        List<String> mode = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            gueLen[i] = in.nextInt();
        }
        in.nextLine();

        for(int i = 0; i < m; i++) {
            mode.add(in.nextLine());
        }

        if(m > n) {
            System.out.println(0);
        }
        System.out.println(wordBreak(s, mode));
    }



    //字符串是否是由其他字符串组合而成
    public static int wordBreak(String s, List<String> word) {
//        Set<String> set = new HashSet<>(word);
        int cnt = 0;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && word.contains(s.substring(j,i + 1))) {
                    dp[i] = true;
                    if(i == s.length() - 1) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}

package codetop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zero
 * @date 2022/8/25 12:55
 * @description 动态规划：dp[i]表示以字符i结尾的字符串是否是由模式串中的字符组成
 * @since 1.8
 **/
public class 单词拆分 {
    // 遍历字符，然后遍历从0到当前字符的所有字符串，如果其中某段截取在模式中，并且上一串字符也在模式串中，就都由模式串组成
    public boolean wordBreak(String s, List<String> word) {
        Set<String> set = new HashSet<>(word);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

package codetop;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/3/28 10:43
 * @description
 * @since 1.8
 **/
public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        //单个字符就是一个序列
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            //第i个位置前的所有比其小的数字都作为一个单独的子序列
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}

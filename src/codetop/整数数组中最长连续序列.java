package codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zero
 * @date 2022/8/25 14:54
 * @description
 * @since 1.8
 **/
public class 整数数组中最长连续序列 {
    public int longestSe(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int cur = num;
                int len = 1;
                while(set.contains(cur + 1)) {
                    cur += 1;
                    len += 1;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}

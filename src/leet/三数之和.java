package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zero
 * @date 2022/4/11 15:59
 * @description 利用双指针优化，将时间复杂度降为o(n)的平方
 * @since 1.8
 **/
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        //先对数组进行排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] +nums[r];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while(l < r &&nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }
        return result;

    }
}

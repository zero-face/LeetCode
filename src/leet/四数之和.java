package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zero
 * @date 2022/3/25 13:15
 * @description
 * @since 1.8
 **/
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if((long)nums[i] + nums[n - 1] + nums[n - 2] +nums[n - 3] < target) {
                continue;
            }
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if((long)nums[i] + nums[j] + nums[n - 1] +nums[n - 2] < target) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if(sum > target) {
                        right--;
                    } else {
                        ==4567890-53460-=345567=88=====
}

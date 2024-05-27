package interview150;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2024/5/28 0:05
 * @description
 * @since 1.8
 **/
public class 删除有序数组中的重复项_最多重复两次 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针，如果快指针所指定的元素不满足重复条件，那么就将快指针的值赋值到慢指针元素的位置，
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow-2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}

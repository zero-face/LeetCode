package interview150;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2024/5/29 20:11
 * @description
 * @since 1.8
 **/
public class 多数元素 {
    public static void main(String[] args) {
        final int[] ints = {3, 2, 2, 2, 2, 4, 5};
        System.out.println(majorityElement(ints));
        System.out.println(Arrays.toString(ints));
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

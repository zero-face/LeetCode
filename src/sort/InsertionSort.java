package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 19:10
 * @description
 * @since 1.8
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        insert(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insert(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i;
            for (; j > 0 && tmp < nums[j - 1]; j--) {
                nums[i] = nums[i - 1];
            }
            nums[j] = tmp;
        }
    }
}

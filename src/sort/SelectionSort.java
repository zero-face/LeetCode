package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 18:46
 * @description
 * @since 1.8
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        final int[] select = select(nums);
        System.out.println(Arrays.toString(select));

    }

    public static int[] select(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tem = nums[i];
            nums[i] = nums[min];
            nums[min] = tem;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}

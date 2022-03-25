package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 18:54
 * @description
 * @since 1.8
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubble(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            boolean swatch = false;
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j+1]) {
                    swatch = true;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = tmp;
                }
            }
            if(!swatch) {
                System.out.println(i);
                System.out.println(Arrays.toString(nums));
                return;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

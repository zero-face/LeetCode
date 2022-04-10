package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 19:22
 * @description 希尔排序
 * @since 1.8
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        shell(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void shell(int[] nums) {
        for(int d = nums.length / 2; d > 0; d /= 2) {
            //不同的增量，最终d=1
            for(int i = d; i < nums.length; i++) {
                //插入的优化，显示d到0 ，后面 d +d 到 d 到 0，插入过程
                for(int j = i - d; j >= 0; j-= d) {
                    if(nums[j] > nums[j + d]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + d];
                        nums[j + d] = tmp;
                    }
                }
            }
        }
    }
}

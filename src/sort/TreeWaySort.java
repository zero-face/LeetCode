package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/3/1 21:53
 * @description
 * @since 1.8
 **/
public class TreeWaySort {
    //lt 到 gt中间的数都是相等的
    private static int[] nums = new int[]{1,1,1,3,3,3,5,3,21,1,3};
    public static void sort( int start, int end) {
        if(start > end) {
            return;
        }
        int lt = start;
        int i = lt + 1;
        int gt = end;
        //基数
        int index = nums[lt];
        while(i <= gt) {
            if(nums[i] < index) {
                //如果比基数小，把当前数和第一相等位置的数交换并且当前数和第一个相等位置都加1
                swap(i++, lt++);
            } else if(nums[i] > index) {
                //如果比基数大，交换当前数和最后一个数，然后最后一个数前移
                swap(i, gt--);
            } else {
                //如果两数相等，那么直接i++;最终实现lt到gt的数都是相等的数
                i++;
            }
        }
        sort(start,lt - 1);
        sort(gt + 1, end);
    }

    private static void swap(int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

    public static void main(String[] args) {
        sort(0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}

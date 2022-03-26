package sort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2021/11/21 19:39
 * @description 二路归并排序
 * @since 1.8
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1,23,445,43,564,43};
        merger(nums,0, nums.length - 1,new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }
    public static void merger(int[] nums, int left,int right,int[] temp) {
        if(left < right) {
            //确定中点
            int mid = (left + right) / 2;
            //合并左边
            merger(nums, left, mid, temp);
            //合并右边
            merger(nums,mid + 1, right, temp);
            //两路合并
            merge(nums, left, mid, right, temp);
        }
    }
    //两路归并m + n
    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[t++] = nums[i++];
        }
        while(j <= right) {
            temp[t++] = nums[j++];
        }
        //将临时数组复制会原数组
        t= 0;
        while(left <= right) {
            nums[left++] = temp[t++];
        }
    }
}

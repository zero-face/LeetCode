package interview150;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2024/5/27 23:12
 * @description
 * @since 1.8
 **/
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 简单提醒：由于是有序的数组，所以从后往前比较，大的放到最后面即可。
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 || j >= 0) {
            int num1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int num2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            if(num1 >= num2) {
                nums1[--k] = nums1[i];
                i--;
            } else {
                nums1[--k] = nums2[j];
                j--;
            }
        }
        while(i >= 0) {
            nums1[--k] = nums1[i];
            i--;
        }
        while(j >= 0) {
            nums1[--k] = nums1[j];
            j--;
        }
    }
}

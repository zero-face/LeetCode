package interview;

/**
 * @author Zero
 * @date 2022/4/11 19:43
 * @description
 * @since 1.8
 **/
import sort.MergeSort;

import java.math.BigInteger;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        int[] nums1 = new int[] {4,5,6,0};
        int[] nums2 = new int[] {1};
        System.out.println(Arrays.toString(MergeAarryNum(nums1, nums1.length, nums2, nums2.length)));
    }
    public static int[] MergeAarryNum(int[] nums1, int m, int[] nums2, int n) {
        // write code here
        if(n == 0) {
            return nums1;
        }
        m = 0;
        for(int i : nums1) {
            if(i != 0) {
                m++;
            }else {
                break;
            }
        }
        int r = m + n - 1;
        int mr = m - 1;
        int nr = n - 1;
        while(mr >= 0 && nr >= 0) {
            mr = mr >= 0 ? mr : 0;
            nr = nr >= 0 ? nr : 0;
            if(nums1[mr] >= nums2[nr]) {
                nums1[r--] = nums1[mr--];
            } else {
                nums1[r--] = nums2[nr--];
            }
        }
        int index = 0;
        while(mr < 0 && nr >= 0) {
            nums1[nr] = nums2[nr--];
        }
        return nums1;
    }
}
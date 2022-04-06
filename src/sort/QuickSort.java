package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Zero
 * @date 2021/11/21 19:55
 * @description
 * @since 1.8
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = new int[10];
        for(int i = 0; i < 10; i++) {
            final Random random = new Random();
            for(int j = 0; j < 10; j++) {
                final int i1 = random.nextInt(1000);
                ints[j] = i1;
            }
            quick(ints,0,ints.length - 1);
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(Arrays.toString(ints));

    }
    public static void quick(int[] nums,int left , int right) {
        if(left < right) {
            int i = left;
            int j = right;
            int index= nums[left];
            while(i < j) {
                while(i < j && nums[j] > index) {
                    j--;
                }
                if(i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while(i < j && nums[i] < index) {
                    i++;
                }
                if(i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = index;
            quick(nums,left, i - 1);
            quick(nums,i+ 1, right);
        }
    }
}

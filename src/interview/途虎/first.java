package interview.途虎;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zero
 * @date 2022/8/31 18:59
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        int[] ints = new int[] {6,3,8,1,3,1,2,2};
        int k = 4;
        System.out.println(minimumIncompatibility(ints, k));
    }
    public static int minimumIncompatibility (int[] nums, int k) {
        // write code here
        int[] arr = maxMinValue(nums);
//        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = arr[1];
        int[] ints = new int[max - min + 1];
        for(int num : nums) {
            ints[num - min]++;
        }
        for(int num : ints) {
            if(num > k) {
                return -1;
            }
        }
        int m = nums.length / k;

        List<int[]> list = new ArrayList<>();

        for(int h = 0; h < k; h++) {
            int[] temp = new int[m];
            int j = 0;
            for(int i = 0; i < ints.length; i++) {
                if(j < m && ints[i] > 0) {
                    temp[j++] = i + min;
                    ints[i]--;
                }
            }
            list.add(temp);
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            int[] t = list.get(i);
            int[] arr1 = maxMinValue(t);
            sum += (arr1[0] - arr1[1]);
        }
        return sum;
    }
    public static int[] maxMinValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for(int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        res[0] = max;
        res[1] = min;
        return res;
    }
}

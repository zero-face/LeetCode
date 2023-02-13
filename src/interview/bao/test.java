package interview.bao;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/10/18 18:49
 * @description
 * @since 1.8
 **/
public class test {
    public static void main(String[] args) {
        int[] ints = new int[]{1,4,2,5,6,8,9,11,13};
        quick(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static void quick(int[] ints, int left, int right) {
        if(left < right) {
            int i = left;
            int j = right;
            int index = ints[left];
            while(i < j) {
                while(i < j && ints[j] % 2 != 0) {
                    j--;
                }
                if(i < j) {
                    ints[i] = ints[j];
                    i++;
                }
                while(i < j && ints[i] % 2 == 0) {
                    i++;
                }
                if(i < j) {
                    ints[j] = ints[i];
                    j--;
                }
            }
            ints[i] = index;
        }
    }
}

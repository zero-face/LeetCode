package interview.yunzhi;

import sort.QuickSort;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/11/18 15:35
 * @description
 * @since 1.8
 **/
public class second {
    public static void main(String[] args) {
        int[] ints = new int[]{2,4,2,1,5,7,34,21};
        quickSort(ints,0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
    private static void quickSort(int[] ints, int left, int right) {
        if(left < right) {
            int i = left;
            int j = right;
            int index = ints[left];
            while(i < j) {
                while(i < j && index < ints[j]) {
                    j--;
                }
                if(i < j) {
                    ints[i] = ints[j];
                    i++;
                }
                while(i < j && index > ints[i]) {
                    i++;
                }
                if(i < j) {
                    ints[j] = ints[i];
                    j--;
                }
            }
            ints[i] = index;
            quickSort(ints, left, i - 1);
            quickSort(ints, i + 1, right);
        }
    }
}

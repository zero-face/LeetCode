package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zero
 * @date 2022/9/1 11:25
 * @description
 * @since 1.8
 **/
public class weipai {
    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 2, 3, 4};
        int[] b = new int[] {3, 5, 6};
        merge(a, b);
    }
    public static void merge(int[] a, int[] b) {
        int[] ints = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                ints[k++] = a[i++];
            } else {
                ints[k++] = b[j++];
            }
        }
        while(i < a.length) {
            ints[k++] = a[i++];
        }
        while(j < b.length) {
            ints[k++] = b[j++];
        }

        System.out.println(Arrays.toString(ints));
        res(ints);
        System.out.println(Arrays.toString(ints));

    }
    public static void res(int[] ints) {
        for(int j = 1; j < ints.length; j++) {
            if(ints[j] == ints[j - 1]) {
                int m = ints[j - 1];
                while(ints[j - 1] == m) {
                    for(int h = j - 1; h < ints.length - 1; h++) {
                        ints[h] = ints[h + 1];
                    }
                }
                j--;
            }
        }
    }
}

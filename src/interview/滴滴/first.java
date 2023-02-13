package interview.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/4 19:18
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        Arrays.sort(ints);
        int l = 0, r = 0;
        double sum = 0.0;
        int res = 0;
        while(r < n) {
            sum += ints[r];
            while(sum / (r - l + 1) * k < ints[r]) {
                sum -= ints[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        System.out.println(res);
    }
}

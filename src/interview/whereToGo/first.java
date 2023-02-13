package interview.whereToGo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/7 13:58
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int e = Integer.valueOf(s.substring(0,s.indexOf(",")));
        String s1 = s.substring(s.indexOf(",") + 3, s.length() - 2);
        String[] split = s1.split("],\\[");
        int n = split.length;
        int[][] ints = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                ints[i][j] = Integer.valueOf(split[i].split(",")[j]);
            }
        }
        Arrays.sort(ints, (int[] int1, int[] int2) ->{
            int a0 = int1[0];
            int a1 = int1[1];
            int b0 = int2[0];
            int b1 = int2[1];
            return a1 / a0 - b1/ b0;
        });
        int sum = 0;

        boolean flag = false;
        int index = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(e == 0) {
                break;
            }
            if(e < 0) {
                sum -= ints[i + 1][1];
                e += ints[i + 1][0];
                flag = true;
                index = i + 1;
                continue;
            }

            flag = false;
            sum += ints[i][1];
            e -= ints[i][0];
        }
        if(flag) {
            sum += ints[index][1];
        }
        System.out.println(sum);
    }
}

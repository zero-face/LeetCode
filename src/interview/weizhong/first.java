package interview.weizhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/13 20:12
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] ints = new String[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt() + "";
        }
        Arrays.sort(ints, (String s1, String s2) -> {
            return s1.length() - s2.length();
        });
        int[] ints1 = new int[9];
        for(int i = n - 1; i > ints.length; i++) {
            ints1[ints[i].length()]++;
        }
        int k = 3;
        int max = -1, min = -1, mid = -1;
        for(int i = 8; i >= 0; i--) {
            while(ints1[i] > 0) {
                ints1[i]--;
                if(max == -1) {
                    max = i;
                }
                if(max != -1) {
                    mid = i;
                }
                if(mid != -1) {
                    min = i;
                }
            }
            if(min != -1) {
                break;
            }
        }
        String res = "";
        for(int i = n - 1; i >= n - 3; i--) {
            res += ints[i];
        }
        System.out.println(res);
    }
}

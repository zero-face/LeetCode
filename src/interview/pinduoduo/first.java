package interview.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/3 16:36
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            char[] chs = s.toCharArray();
            int[] ints = new int[n];
            int max = 0;
            for(int i = 0; i < n; i++) {
                char ch = chs[i];
                ints[i] = ch - k;
                max = Math.max(max,ch);
                if(ch >= ints[i] && ch <= max) {
//                    chs[i] =
                }
            }
            System.out.println(chs);
        }


    }
}

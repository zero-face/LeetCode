package interview.mayi;

import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/22 09:37
 * @description
 * @since 1.8
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        int k = in.nextInt();
        int len = lenK(k);
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 1; j <= len; j++) {
                int t = Integer.valueOf(s.substring(i, j + i > s.length() ? s.length() : j + i));
                if(t < k) {
                    res++;
                    if(i >= s.length() - len) {
                        break;
                    }
                }

            }
        }
        System.out.println(res);
    }
    public static int lenK(int k ) {
        int len = 0;
        while(k != 0) {
            k /= 10;
            len ++;
        }
        return len;
    }
}

package interview.美团笔试;

import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/8/27 15:50
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String S = in.nextLine();
        String s = in.nextLine();
//        System.out.println(n);
//        System.out.println(m);
        int res = 0;
        for (int i = 0; i <= n - m; i++) {
            String str = S.substring(i, m + i);
//            System.out.println(str);
            int j = 0;
            for(; j < m; j++) {
                if(s.charAt(j) != '*' && str.charAt(j) != s.charAt(j)) {
                    break;
                }
            }
            if(j == m) {
                res++;
            }
        }
        System.out.println(res);

    }
}

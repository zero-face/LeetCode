package interview.mihayou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/14 19:27
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        int m = k;
        in.nextLine();
        String str = in.nextLine();
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 6, s = 0;
        while(r <= n) {
            if(str.substring(r - 6, r).equals("mihoyo")) {
                list.add(r - 6);
                k--;
            }
            if(k <= 0) {
                k = m;
            }
            r++;
        }
         System.out.println(list);
        int h = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            if(i >= m - 1 && list.get(i) - list.get(i - m + 1) <= h) {
                l = i - m + 1;
                s = i;
            }
        }
         if(list.size() < m) {
             System.out.println(-1);
             return;
         }
        System.out.println(list.get(l) + " " + (list.get(s) + 5));
    }
}

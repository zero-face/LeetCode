package interview.mihayou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/9/14 20:19
 * @description
 * @since 1.8
 **/
public class s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        in.nextLine();
        int x = in.nextInt();
        int y = in.nextInt();
        if(x == 0 || y == 0) {
            System.out.println("infinity");
            return;
        }
        Arrays.sort(ints);
        int res = ints[n - 1 - x + 1] - ints[y - 1];
        System.out.println(res);
    }
}

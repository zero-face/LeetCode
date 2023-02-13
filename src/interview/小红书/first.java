package interview.小红书;

import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/8/28 16:11
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int id = in.nextInt();
        in.nextLine();
        int[][] ints = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ints[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        int[] all = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                all[i] += ints[i][j];
            }
        }
//        System.out.println(Arrays.toString(all));
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(i < id - 1 && all[i] >= all[id - 1]) {
                count++;
            } else if(all[i] > all[id - 1]) {
                count++;
            }
        }
        System.out.println(count+1);

    }
}

package interview.小红书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/8/28 16:31
 * @description
 * @since 1.8
 **/
public class second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++){
            ints[i] = in.nextInt();
        }
        Arrays.sort(ints);
//        System.out.println(Arrays.toString(ints));
        int res = 0;
        int r = n;
        if(n == 1 && ints[0] >= k) {
            res++;
            System.out.println(res);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(ints[i] >= k) {
                r = i;
                break;
            }
            int j = i + 1;
            while(j < n) {
                int mul = ints[i] * ints[j];
                if(ints[j] >= k) {
                    break;
                }
                if(mul >= k) {
                    res++;
                }
                j++;
            }
        }
        int Dk = n - 1 - r + 1;
        int s1 = Dk == 1 ? 0 : (Dk - 1)  * Dk;
        int sum = Dk * r  * 2 + s1;
        res = res * 2 + sum;
        System.out.println(res);
    }
}

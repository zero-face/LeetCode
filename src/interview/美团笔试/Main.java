package interview.美团笔试;

/**
 * @author Zero
 * @date 2022/9/3 10:59
 * @description
 * @since 1.8
 **/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
            arr[i] = ints[i];
        }

        for(int i = 0; i < n; i++) {
            while(ints[i] >= 0 && ints[i] < n && ints[i] != ints[ints[i]]) {
                int t = ints[ints[i]];
                ints[ints[i]] = ints[i];
                ints[i] = t;
            }
        }
//        System.out.println(Arrays.toString(ints));
        for(int i = 0; i < n; i++) {
            int k = arr[i];
            int m = 0;
            if(k < n) {
                m = ints[k];
                ints[k] = -1;
            }
            boolean flag = false;
            for(int j = 0; j < n; j++) {
                if(ints[j] != j) {
                    flag = true;
                    System.out.print(j + " ");
                    break;
                }
            }
            if(k < n) {
                ints[k] = m;
            }
            if(!flag)
            System.out.println(n);

        }

    }
}

package interview.京东;

/**
 * @author Zero
 * @date 2022/8/27 18:29
 * @description
 * @since 1.8
 **/
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++) {
            ints[i] = in.nextInt();
        }
        int[] ji = new int[n / 2];
        int[] ou = new int[n / 2];
        int k = 0, m = 0;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                ou[k++] = ints[i];
            } else {
                ji[m++] = ints[i];
            }
        }
        Arrays.sort(ou);
        Arrays.sort(ji);
        System.out.println(Arrays.toString(ou));
        System.out.println(Arrays.toString(ji));
        int j = 0;
        int len = 0;
        int j1 = 0;
        int len1 = 0;
        for(int i = 0; i < ji.length; i++) {
            if(ji[i] != ji[j]) {
                len = Math.max(len, i - j );
                j = i;
            }

        }
        for(int i = 0; i < ou.length; i++) {
            if(ou[i] != ou[j1]) {
                len1 = Math.max(len1, i - j1 );
                j1 = i;
            }
        }
        int h = ou.length - len1 + ji.length - len;
        System.out.println(h);
    }
}
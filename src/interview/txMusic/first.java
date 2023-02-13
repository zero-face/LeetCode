package interview.txMusic;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/9/8 19:00
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        String s = "aaabbbcccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
        System.out.println(minOperations(s));
    }
    public static int minOperations (String str) {
        // write code here
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        int[] ints = new int[26];
        for(char c : chs) {
            ints[c - 'a']++;
        }
        int res = 0;
        int count = 0;
        for(int i : ints) {
            if(i == 0) {
                count++;
            }
        }
        for(int i = 0; i < ints.length; i++) {
             while(ints[i] > 1) {
                 ints[i] -= 2;
                 res++;
                 if(ints[i] == 0) {
                    count++;
                 }

                 count--;
                 if(count < 0) {
                    ints[i]++;
                }
             }
        }
        return res;
    }
}
// while(ints[i] > 1) {
//         ints[i] -= 2;
//         res++;
//         if(ints[i] == 0) {
//         count++;
//         }
//         count--;
//         if(count < 0) {
//        res++;
//        count = 1;
//        }
//        }
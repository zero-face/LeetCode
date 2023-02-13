package interview.baidu;

import java.util.*;

/**
 * @author Zero
 * @date 2022/9/13 19:23
 * @description
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<Character> list = new ArrayList(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int i = 0, j = 4;
        Set<String> set = new HashSet<>();
        int res = 0;
        while(j < s.length()) {
            boolean flag = false;
            String str = s.substring(i,j + 1);
            char[] chs = str.toCharArray();
            int[] ints = new int[26];
            int q = 0;
            for(int k = 0; k < chs.length; k++) {
                ints[chs[k] - 'a']++;
                if(ints[chs[k] - 'a'] > 1) {
                    q = 0;
                    break;
                }
                if((k == 0 || k == 3) ) {
                    if(!list.contains(chs[k])) {
                        if (flag == true) {
                            q = 1;
                        }
                        flag = true;
                    }
                } else {
                    if(!list.contains(chs[k])) {
                        q = 0;
                        break;
                    }
                }
            }
            res += q;
            i++;
            j++;
        }
        System.out.println(res);
    }
}

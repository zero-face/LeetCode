package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zero
 * @date 2022/8/27 13:15
 * @description
 * @since 1.8
 **/
public class 最短覆盖子串 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        int cnt = 0;
        String ans = "";
        int j = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c,hs.getOrDefault(c,0) + 1);
            //t中包含了当前的字符并且窗口中的字符小于t中的字符个数
            if(ht.containsKey(c) && hs.get(c) <= ht.get(c)) {
                cnt++;
            }
            while (j < i && (!ht.containsKey(c) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
            }
            if(cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }
}

package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zero
 * @date 2022/3/25 11:57
 * @description 使用一个队列存储不重复子串，遍历字符的时候判断队列中是否含有该字符，有的情况下，直接while抛出重复字符前面的所有字符
 * @since 1.8
 **/
public class 无重复最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        if(s == null || s == "") {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            while(queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.add(s.charAt(i));
            res = Math.max(res,queue.size());
        }
        return res;
    }
}

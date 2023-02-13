package interview.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zero
 * @date 2022/10/24 15:56
 * @description
 *
 * Longest Substring Without Repeating Characters
 * Input: s = "abcabcbb"
 * Output: 3
 *
 * Input: s = "bbbbb"
 * Output: 1
 *
 *
 *
 *
 * [-3,-1, 0, 1, 2, 4] 升序数组
 * 平方后升序输出，要求时间复杂度O（n）
 * output:[0,1,1,4,9,16]
 * @since 1.8
 **/
public class first {
    public static void main(String[] args) {
        String str = "";
        System.out.println(res(str));
    }

    private static int[] res1(int[] ints) {

        for(int i = 0; i < ints.length; i++) {

        }


        return ints;
    }
    private static int res(String str) {
        Queue<Character> queue = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {
            while(queue.contains(str.charAt(i))) {
                queue.poll();
            }
            queue.add(str.charAt(i));
            ans = Math.max(ans,queue.size());
        }
        return ans;
    }
}

package interview.途虎;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Zero
 * @date 2022/8/31 20:06
 * @description
 * @since 1.8
 **/
public class second {
    public static void main(String[] args) {
        int[] oils = new int[] {1, 2, 5};
        int box = 11;
        System.out.println(change(oils, box));
    }
    public static int change (int[] oils, int box) {
        // write code here
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(oils, box, res, stack);

        int min = Integer.MAX_VALUE;
        for(int i : res) {
            min = Math.min(min,i);
        }
        return min;
    }
    public static void dfs(int[] oils, int box, List<Integer> res, Deque<Integer> stack) {
        if(box == 0) {
            res.add(stack.size());
        }
        if(box < 0) {
            return;
        }
        for(int i = 0; i < oils.length; i++) {
            stack.push(oils[i]);
            dfs(oils, box - oils[i], res, stack);
            stack.pop();
        }
    }
}

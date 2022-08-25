package leet;

import java.util.*;

/**
 * @author Zero
 * @date 2022/8/16 20:48
 * @description
 * @since 1.8
 **/
public class 无重复字符全排列 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, n, used, stack);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> list, int depth, int n, boolean[] used, Deque<Integer> stack) {
        if(depth == n) {
            list.add(new ArrayList<Integer>(stack));
            return;
        }
        //数组中挑选数来查看是否被用，递归下一个位置()
        //有重复字符的数组来说，我们要将数组排序，保证同一位置每次填充的字符只能是一次，所以只有保证相同字符中的前一个字符已经被填充才能去掉重复的。
        //所以剪枝的条件为前一个字符==后一个字符的情况下，前一个字符已经被使用了，否则跳过。
        for(int i = 0; i < n; i++) {
            if(used[i] /*|| (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))*/ ){
                continue;
            }
            stack.addLast(nums[i]);
            used[i] = true;
            dfs(nums,list,depth + 1, n,used,stack);
            used[i] = false;
            stack.removeLast();
        }
    }
}

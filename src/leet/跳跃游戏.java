package leet;

/**
 * @author Zero
 * @date 2022/3/29 14:03
 * @description
 * @since 1.8
 **/
public class 跳跃游戏 {
    //这里需要想到：当遍历的位置已经在能到达的最大下标的右边，那么就肯定能到达
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //能到达的最大下标
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //如果遍历到的位置还在最大能到达的前面
            if (i <= rightmost) {
                //是否能更新最大能到达的位置
                rightmost = Math.max(rightmost, i + nums[i]);
                //如果最大的位置已经大于等于最后一个下标就是可到达
                if (rightmost >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}

package leet;

/**
 * @author Zero
 * @date 2022/8/16 21:41
 * @description
 * @since 1.8
 **/
public class 跳跃有些2 {
    //1找出是否能跳到，2则是判断出多少步

    //从左至右找到第一个能跳到最后位置的然后最后位置变为能跳到它那个位置，再次循环，直到能跳到目标的那个位置为0
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        //只有要跳到的位置为0 的时候跳出循环
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                //如果找到能跳到目标的第一个位置，就将这个位置作为下一轮跳跃的目标
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}

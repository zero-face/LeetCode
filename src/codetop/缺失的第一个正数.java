package codetop;

/**
 * @author Zero
 * @date 2022/8/25 14:58
 * @description 将数组转换成一个哈希表，缺失的正数肯定在1-n或者是N+1
 * @since 1.8
 **/
public class 缺失的第一个正数 {
    public int firstNum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return 1 + n;
    }
}

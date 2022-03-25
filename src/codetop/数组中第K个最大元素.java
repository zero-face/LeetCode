package codetop;

/**
 * @author Zero
 * @date 2022/3/25 12:29
 * @description 计数排序的思想，排序后找到第K大元素即可
 * @since 1.8
 **/
public class 数组中第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 找出数组A中的最大值、最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 初始化计数数组count
        // 长度为最大值减最小值加1
        int[] count = new int[max - min + 1];
        // 对计数数组各元素赋值
        for (int num : nums) {
            // A中的元素要减去最小值，再作为新索引
            count[num - min]++;
        }
        // 计数数组变形，新元素的值是前面元素累加之和的值
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            //nums[j]前面有i个数
            int i = count[nums[j] - min] - 1;
            result[i] = nums[j];
            count[nums[j] - min]--;
            if(i == nums.length - k) {
                return nums[j];
            }
        }
        return -1;
    }

}

package codetop;

/**
 * @author Zero
 * @date 2022/3/28 10:48
 * @description 思想：从后往前找到第一比上一个节点小的位置。那么就将这个位置的数字和从后往前第一个比他大的数字进行交换，这样就做到了在这个位上比原数大，但是最接近，最后将后面的所有序列反转即可。
 * @since 1.8
 **/
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int index = -1;
        //从后往前找到第一个递增的位置
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] >= nums[i + 1]) {
                continue;
            }
            index = i;
            break;
        }
        //如果没有找到，那么说明此时数组的值是最大值，那么直接反正数组就行
        if(index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //从后往前找到第一个比递增位置大的值，交换
        for(int i = nums.length - 1; i > index; i--) {
            if(nums[i] > nums[index]) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                break;
            }
        }
        //反转递增后面的所有数字，即可
        reverse(nums, index + 1, nums.length - 1);
    }
    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}

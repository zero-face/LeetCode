package leet;

/**
 * @author Zero
 * @date 2022/3/25 13:10
 * @description
 * @since 1.8
 **/
public class 盛水最多的容器 {
    public int maxArea(int[] height) {
        //双指针指向两边，容量等于晓得一个* 距离差；此时移动高度小的一边，再计算容量。
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}

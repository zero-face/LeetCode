package codetop.区间操作;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zero
 * @date 2022/3/28 21:48
 * @description
 * @since 1.8
 **/
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //首先按照数组一维坐标进行排序，让其起点具有先后顺序
        Arrays.sort(intervals, (int[] interval1, int[] interval2) ->{
                    return interval1[0] - interval2[0];
                }
        );
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            //保存当前数组范围的起点和中点
            int l = intervals[i][0], r = intervals[i][1];
            //如果最后一个点的中点比当前点的起点还小，那么说明两点没有重合，那么就将当前点保存进入集合
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < l){
                merged.add(new int[]{l, r});
            } else {
                //如果当前点的起点比上一个点的中点还小，那么说明两点之间有重合，就找到这两点中中点较大的那个组成一个更大的区间范围即可。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        int res = 0;
        for(int i = 0; i < merged.size(); i++) {
            res +=(merged.get(i)[1] - merged.get(i)[0]);
        }
        System.out.println(res);
        return merged.toArray(new int[merged.size()][]);
    }
}

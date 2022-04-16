package leet;

import java.util.Arrays;

/**
 * @author Zero
 * @date 2022/4/11 15:50
 * @description
 * @since 1.8
 **/
public class 最长公共前缀 {
    //先对数组排序，然后直接比较最后一个字符串和第一个字符串就可以找出最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String last = strs[strs.length - 1];
        int len = strs[0].length() < last.length() ? strs[0].length() : last.length();
        int index = -1;
        for(int i = 0; i < len; i++) {
            if(strs[0].charAt(i) != last.charAt(i)) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return strs[0];
        }
        return strs[0].substring(0, index);
    }

}

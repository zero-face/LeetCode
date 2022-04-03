package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zero
 * @date 2022/3/28 9:45
 * @description
 * @since 1.8
 **/
public class 括号生成 {
    //核心思想：n-1个括号分为两组，一组放在括号中间（可以有0到n-1个括号），一组放在括号外面；所以用动态规划
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        //二维数组来存储括号方案
        List<List<String>> dp  = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i = 1; i <=n; i++) {
            List<String> cur = new ArrayList<>();
            //括号内是j个括号对，最多是i-1个括号对
            for(int j = 0; j < i; j++) {
                //取出是j个括号对的list
                List<String> inner = dp.get(j);
                //取出是i - 1- j的括号对list
                List<String> outer = dp.get(i - 1 - j);
                //遍历括号内方案
                for(String l: inner) {
                    //遍历括号外的方案
                    for(String r: outer) {
                        cur.add("(" + l + ")" + r);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);

    }
}

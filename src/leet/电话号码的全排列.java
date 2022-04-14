package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zero
 * @date 2022/3/25 13:11
 * @description
 * @since 1.8
 **/
public class 电话号码的全排列 {
    //列举所有数字对应的字符串，然后使用回溯的方法列穷举所有可能
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        Map<Character, String> maps = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        back(res, digits, 0, new StringBuffer(), maps);
        return res;
    }

    private void back(List<String> res, String digits, int index, StringBuffer str, Map<Character,String> maps) {
        if(index == digits.length()) {
            res.add(str.toString());
        } else {
            char s = digits.charAt(index);
            String letters = maps.get(s);
            int len = letters.length();
            for(int i = 0; i < len; i++) {
                str.append(letters.charAt(i));
                back(res, digits, index + 1, str, maps);
                str.deleteCharAt(index);
            }
        }

    }
}

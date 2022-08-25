package interview;

/**
 * @author Zero
 * @date 2022/4/18 20:21
 * @description
 * @since 1.8
 **/
public class t {
    static int l = 0, r= 0;
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        // write code here

        if(s == null || s.length() == 1 || s == "") {
            return s;
        }
        int len = s.length();
        for(int i = 0; i < len; i++) {
            index(i, i, s);
            index(i, i + 1, s);
        }
        return s.substring(l, r);
    }
    public static void index(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if(right - left - 1 > r - l) {
            l = left + 1;
            r = right;
        }
    }
}

package leet;

/**
 * @author Zero
 * @date 2022/3/25 13:09
 * @description
 * @since 1.8
 **/
public class 整数反转 {
    //本题思路就是将整数完全反转过来（我们每次取出最后一位，然后用最后一位作为首位来构造相反的数值==》res*10 + digit）
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

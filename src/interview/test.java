package interview;

/**
 * @author Zero
 * @date 2022/4/18 19:54
 * @description
 * @since 1.8
 **/
public class test {
    public static void main(String[] args) {
        String s = "shoppe";
        int n = 2;
        System.out.println(LeftShiftOne(s, n));
//        System.out.println(s.substring(n) + s.substring(0, n));
    }
    public static String LeftShiftOne(String s, int n) {
        // write code here
        int j = 0;
        int k = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] left = new char[n];
        char[] right = new char[len - n];
        for(int i = 0; i < len; i++) {
            if(i < n) {
                left[j++] = s.charAt(i);
            } else {
                right[k++] = s.charAt(i);
            }

        }
        for(int i = 0; i < len - n; i++) {
            chars[i] = right[i];
        }
        for(int i = 0; i < n; i++) {
            chars[i +len - n] = left[i];
        }
        return new String(chars);
    }
}

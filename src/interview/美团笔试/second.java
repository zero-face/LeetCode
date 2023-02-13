package interview.美团笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zero
 * @date 2022/8/27 16:24
 * @description
 * @since 1.8
 **/
public class second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            list.add(in.nextInt());
        }
        int[] arr = new int[n];
        int k = m;
        arr[0] = 1;
        for(int i = 0; i < n; i++) {
            int num = i + 1;
            if(list.contains(num)) {
                continue;
            }
            arr[k++] = num;
        }
        for(int i = 0; i < m; i++) {
            arr[i] = list.get(m - i - 1);
        }
        System.out.println(Arrays.toString(arr));
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        in.nextLine();
//        int[] ints = new int[m];
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        for(int i = 0; i < m; i++) {
//            list.add(in.nextInt());
//        }
//        for(int i = 0; i < n; i++) {
//            int k = i + 1;
//            if(list.contains(k)) {
//                continue;
//            }
//            list1.add(k);
//        }
//        List<Integer> res = new ArrayList<>();
//        for(int i = m - 1; i >= 0; i--) {
//            res.add(list.get(i));
//        }
//        for(int i = 0; i < list1.size(); i++) {
//            res.add(list1.get(i));
//        }
//        for(int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
//    }
}

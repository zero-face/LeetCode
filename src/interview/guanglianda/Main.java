package interview.guanglianda;

/**
 * @author Zero
 * @date 2022/8/31 21:44
 * @description
 * @since 1.8
 **/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[][] ints = new int[m][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 3; j++) {
                ints[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        Arrays.sort(ints, (int[] arr1, int[] arr2) -> {
            return arr1[0] - arr2[0];
        });
        List<int[]> list = new ArrayList<>();

        list.add(new int[] {ints[0][0], ints[0][1], ints[0][2]});
        for(int i = 1; i < m; i++) {
            int l = ints[i][0];
            int r = ints[i][1];
            int k = ints[i][2];
            int lastL = list.get(list.size() - 1)[0];
            int lastR = list.get(list.size() - 1)[1];
            int lastK = list.get(list.size() - 1)[2];
            if(list.size() == 0 || lastR < l) {
                list.add(new int[] {l, r, k});
            } else if(lastR > r){
                list.get(list.size() - 1)[2] = k + ( lastR -  lastL - r + l >= lastK ? lastK : lastR -  lastL - r + l);
            } else if(r > lastR){
                list.get(list.size() - 1)[1] = Math.max(lastR, r);
                if(lastR - lastL + 1 >= lastK) {
                    list.get(list.size() - 1)[2] = k + lastK;
                } else {
                    int t = r - l + 1 - (lastK - (lastR - lastK + 1));
                    list.get(list.size() - 1)[2] = lastK + (k > t ? t : k);
                }
            }
        }
        int sum = 0;
        sum += list.get(0)[0] - 0 - 1 + list.get(0)[2];
        for(int i = 1; i < list.size(); i++) {
            int[] arr = list.get(i);
            int[] last = list.get(i - 1);
            sum += arr[2];
            sum +=(arr[0] - last[1] - 1);

        }
        sum += n - list.get(list.size() - 1)[1];

        System.out.println(sum);
    }
}
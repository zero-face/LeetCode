package leet;

/**
 * @author Zero
 * @date 2022/3/26 12:17
 * @description
 * @since 1.8
 **/
public class Pow {
    public double myPow(double x, int n) {
        long b = n;
        //当幂小于0，说明x要变为倒数，然后再进行计算。
        if(b < 0) {
            return Pow(1 / x, -b);
        }
        return Pow(x, b);

    }

    public double Pow(double x, long n) {
        //首先排除特殊情况
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(x == 1) {
            return 1;
        }
        //递归的原酸出n / 2的temp，然后判断幂是否为偶数，是则是结果的平方
        double temp = Pow(x, n / 2);
        if (n % 2 == 0) return temp * temp;
        return temp * temp * x;
    }


}

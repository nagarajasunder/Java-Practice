//https://leetcode.com/problems/sqrtx/submissions/
public class SqrtOfANumber {

    public static void main(String[] args) {
        System.out.println(mySqrt(23));
    }

    public static int mySqrt(int n) {
        int s = 1, e = n, a = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid * mid == n)
                return mid;
            else if (n > mid * mid) {
                s = mid + 1;
                a = mid;
            } else {
                e = mid - 1;
            }
        }

        return a;
    }

}

//Problem link https://leetcode.com/problems/maximum-subarray/
//Kadane Algorithm
public class MaximumSubArray {

    public int maxSubArray(int[] arr) {
        int sum = 0, max = arr[0];

        for (int j : arr) {
            sum += j;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}

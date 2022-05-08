public class RangeSum {
    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[]{-2,0,3,-5,2,-1});

    }
}

class NumArray {

    int[] rangeSum;
    int len;

    public NumArray(int[] nums) {
        len = nums.length;
        rangeSum = new int[len];
        calculateRangeSum(nums, len);
        printRangeSum();
    }

    private void printRangeSum() {
        for (int i : rangeSum) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private void calculateRangeSum(int[] nums, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            rangeSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return rangeSum[right];
    }
}

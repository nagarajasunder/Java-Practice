public class NextPermutation {

    public static void main(String[] args) {

        int[] arr = new int[]{3,1,2};

        nextPermutation(arr);
        printArr(arr);

    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    
        public static void nextPermutation(int[] nums) {

        int n = nums.length - 1;

        int breakingPointIndex = -1;
        int nextGreaterIndex = -1;

        //Step 1

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakingPointIndex = i;
                break;
            }
        }

        if (breakingPointIndex == -1) {
            swap(nums, 0, n);
            return;
        }

        //Step 2
        for (int i = n; i >= 0; i--) {
            if (nums[i] > nums[breakingPointIndex]) {
                nextGreaterIndex = i;
                break;
            }
        }

        //Step 3
        int temp = nums[breakingPointIndex];
        nums[breakingPointIndex] = nums[nextGreaterIndex];
        nums[nextGreaterIndex] = temp;

        swap(nums, breakingPointIndex + 1, n);


    }

    //Step 4
    public static void swap(int[] arr, int swapFrom, int len) {
        while (swapFrom < len) {
            int temp = arr[swapFrom];
            arr[swapFrom] = arr[len];
            arr[len] = temp;
            swapFrom++;
            len--;
        }
    }

}

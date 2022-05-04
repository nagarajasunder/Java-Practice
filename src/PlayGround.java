class PlayGround {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        sortArrayByParityII(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if ((i % 2 == 1) && (nums[i] % 2 == 1)) {
                i++;
            } else if ((i % 2 == 0) && (nums[i] % 2 == 0)) {
                i++;
            } else {
                if ((i % 2 == 0) && (nums[i] % 2 != 0)) {
                    if (j % 2 == 1 && nums[j] % 2 != 1) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    } else if (j % 2 == 0 && nums[j] % 2 != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    }
                } else {
                    if (j % 2 == 0 && nums[j] % 2 != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    } else if (j % 2 == 1 && nums[j] % 2 != 1) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    }
                }
            }

            if ((j % 2 == 1) && (nums[j] % 2 == 1)) {
                j--;
            } else if ((j % 2 == 0) && (nums[j] % 2 == 0)) {
                j--;
            } else {
                if ((j % 2 == 0) && (nums[j] % 2 != 0)) {
                    if (i % 2 == 1 && nums[i] % 2 != 1) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        j--;
                    } else if (i % 2 == 0 && nums[i] % 2 != 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        j--;
                    }
                } else {
                    if (i % 2 == 0 && nums[i] % 2 != 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        j--;
                    } else if (i % 2 == 1 && nums[i] % 2 != 1) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        j--;
                    }
                }
            }
        }

        return nums;
    }
}
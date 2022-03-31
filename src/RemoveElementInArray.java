public class RemoveElementInArray {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public static int removeElement(int[] nums, int val) {

        int i = 0, j = 0;

        while (i < nums.length && j < nums.length) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            } else {
                i++;
            }
            j++;

        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("i "+i);

        return i;
    }
}

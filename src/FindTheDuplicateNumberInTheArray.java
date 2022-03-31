public class FindTheDuplicateNumberInTheArray {

    public static void main(String[] args) {

        System.out.println(findDuplicate(new int[]{1,2,3,2,4}));
    }

    public static int findDuplicate(int[] nums) {


        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
}



//problem link https://leetcode.com/problems/move-zeroes/

public class MoveZeros {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {

        int i = 0,j = 0;

        int n = nums.length;

        while(i<n && j< n)
        {
            if(nums[i] == 0)
            {
                if(nums[j] != 0)
                {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
            }
            else
            {
                i++;
            }
            j++;
        }



    }

}

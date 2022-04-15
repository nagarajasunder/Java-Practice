public class StartAndEndPositionOfAElementInArray {

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length-1;
        int[] result = new int[2];
        return binarySearch(0,n,nums,target,result);
    }


    public static int[] binarySearch(int l , int h , int[] arr , int search,int[] result)
    {
        while(l<=h)
        {
            int mid = (l+h)/2;

            if(arr[mid] == search)
            {
                int[] leftSide = binarySearch(l,mid-1,arr,search,result);
                int[] rightSide = binarySearch(mid+1,h,arr,search,result);
                result[0] = leftSide[0] == -1?Math.min(result[0],mid):Math.min(result[0],leftSide[0]);
                result[1] = rightSide[1] == -1?Math.max(result[0],mid):Math.max(result[0],rightSide[1]);

                return result;
            }
            else if(arr[mid] < search)
            {
                l = mid+1;
            }
            else
            {
                h = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}

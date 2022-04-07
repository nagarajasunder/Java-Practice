public class MaximumArea {
//    public int maxArea(int[] height) {
//
//        int i = 0, j = height.length - 1;
//
//        int maxArea = 0,temp = 0;
//
//        while (i < j) {
//            if (height[i] <= height[j]) {
//                temp = height[i] * (j - i);
//                i++;
//            } else {
//                temp = height[j] * (j - i);
//                j--;
//            }
//
//            if (temp >= maxArea) {
//                maxArea = temp;
//            }
//
//        }
//
//        return maxArea;
//
//
//    }

    //Another solution
    public int maxArea1(int[] height) {

        int left = 0, right = height.length - 1;

        int maxArea = 0, temp = 0;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];

            maxArea = Math.max(maxArea, Math.min(hLeft, hRight) * (right - left));

            if (hLeft < hRight) {
                while (left < right && height[left] <= height[right]) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= height[left]) {
                    right--;
                }
            }

        }

        return maxArea;


    }
}
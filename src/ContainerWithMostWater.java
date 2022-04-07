//problem link https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;

        int maxArea = 0, temp = 0;

        while (i < j) {
            if (height[i] <= height[j]) {
                temp = height[i] * (j - i);
                i++;
            } else {
                temp = height[j] * (j - i);
                j--;
            }

            if (temp >= maxArea) {
                maxArea = temp;
            }

        }

        return maxArea;


    }
}

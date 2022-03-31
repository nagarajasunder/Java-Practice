import java.util.Scanner;

public class SearchA2DMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};


        for (int[] ints : arr) {
            int result = binarySearch(ints, 3, 0, arr[0].length - 1);
            if (result == -1) {
                System.out.println(result);
                break;
            }

        }
        System.out.println(false);


    }

    public static int binarySearch(int[] arr, int search, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (search == arr[mid]) {
                return mid;
            } else if (search < arr[mid]) {
                return binarySearch(arr, search, low, mid - 1);
            } else {
                return binarySearch(arr, search, mid + 1, high);
            }

        }
        return -1;
    }
}


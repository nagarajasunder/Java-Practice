public class SortArray {

    public static void main(String[] args) {

        int[] arr = sortArr(new int[]{8,2,4,1,3}, 5);

    }

    public static int[] sortArr(int[] arr, int n) {

        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int swapPos = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > currentElement) {
                    arr[j + 1] = arr[j];
                    swapPos = j;
                }
            }
            if (swapPos != -1) {
                arr[swapPos] = currentElement;
            }
            printArray(arr);
        }

        return arr;
    }

    private static void printArray(int[] arr) {
        for(int i:arr)
        {
            System.out.print(i);
        }
        System.out.println();
    }
}

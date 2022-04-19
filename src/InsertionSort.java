public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,4,6,1,3};

        sort(arr);

        printArray(arr);
    }

    public static void sort(int[] arr) {

        int key;

        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >= 0 && key > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

    }

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

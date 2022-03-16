public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,3,9,7};

        sort(arr);
    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int index = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                    index = j;

                }
            }
            if (index != -1)
            {
                arr[index] = key;
            }

        }




    }

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

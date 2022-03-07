public class MergeSort {

    static int[] arr = new int[]{12, 11, 13, 5, 6, 7};
    public static void main(String[] args) {
        sortArray(0, arr.length-1);
        for (int i : arr)
        {
            System.out.print(" "+i);
        }
    }

    public static void sortArray(int low, int high) {
        if (low < high) {
//            System.out.println("If Low "+low+" High "+high);

            int mid = (low+high)/2;
            sortArray(low, mid);
            sortArray(mid + 1, high);
            merge(arr , low, mid, high);
        } else {
//            System.out.println("Else Low "+low);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L1 = new int[n1];
        int[] L2 = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L1[i] = arr[low+i];
        }
        for (int j = 0; j < n2; ++j) {
            L2[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L1[i] <= L2[j]) {
                arr[k] = L1[i];
                i++;
            } else {
                arr[k] = L2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = L2[j];
            j++;
            k++;
        }
        System.out.println("Merging low " + low + " to mid " + mid + " to high " + high);
        for (int d : arr)
        {
            System.out.print(" "+d);
        }
        System.out.println();

    }
}

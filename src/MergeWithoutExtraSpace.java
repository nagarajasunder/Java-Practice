public class MergeWithoutExtraSpace {

    public static void main(String[] args) {
        long[] arr1 = new long[]{1, 3, 5, 7};
        long[] arr2 = new long[]{0, 2, 6, 8, 9};

        merge(arr1, arr2, arr1.length, arr2.length);

    }

    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int i = 0;
        while (i < n) {
            if (arr1[i] >= arr2[0]) {
                long temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
                sort(0, m-1, arr2);
            }
            i++;
        }
    }

    static void sort(int low, int high, long[] arr) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid, arr);
            sort(mid + 1, high, arr);
            mergeArr(low, mid, high, arr);
        }
    }

    static void mergeArr(int low, int mid, int high, long[] arr) {
        int l1 = mid - low + 1;
        int l2 = high - mid;

        long[] left = new long[l1];
        long[] right = new long[l2];

        for (int i = 0; i < l1; i++) {
            left[i] = arr[low + i];
        }

        for (int j = 0; j < l2; j++) {
            right[j] = arr[mid + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < l1 && j < l2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < l2) {
            arr[k] = right[j];
            k++;
            j++;
        }

    }

}

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 0, 0, 3));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        sort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L1 = new int[n1];
        int[] L2 = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L1[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            L2[j] = arr[mid + j + 1];
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
    }
}

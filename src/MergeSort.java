class MergeSortImpl {
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int l1 = mid - low + 1;
        int l2 = high - mid;

        int[] L = new int[l1];
        int[] R = new int[l2];

        for (int i = 0; i < l1; ++i) {
            L[i] = arr[i + low];
        }
        for (int j = 0; j < l2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < l1 && j < l2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < l2) {
            arr[k] = R[j];
            j++;
            k++;
        }

//        System.out.println("For low " + low + " mid " + mid + " high " + high);
//        printArray(arr);
    }

    public void printArray(int[] arr) {
        for (int s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}

public class MergeSort
{
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,4};

        int n = 8;

        long[] odd = new long[n/2];
        long[] even = new long[n/2];

        int odd_index = 0;
        int even_index = 0;

        for(int i = 0;i<n;i++)
        {
            if(i%2 == 0)
            {
                even[even_index] = arr[i];
                even_index++;
            }
            else
            {
                odd[odd_index] = arr[i];
                odd_index++;
            }
        }

    }
}

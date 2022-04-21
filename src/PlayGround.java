class PlayGround {
    public static void main(String[] args) {

        System.out.println(String.valueOf('a').repeat(5));

        int n = 7;
        long[] arr = new long[]{-99,-27,-72,-82,19,56,55,47,66,-20,6,-54,92,50,-38,-68,54,-100,-52};
        bitonicGenerator(arr, arr.length);
    }

    static void bitonicGenerator(long[] arr, int n) {
        long[] odd = new long[(n / 2)+1];
        long[] even = new long[n / 2+1];

        int odd_index = 0;
        int even_index = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[even_index] = arr[i];
                even_index++;
            } else {
                odd[odd_index] = arr[i];
                odd_index++;
            }
        }

        System.out.println(even_index);
        System.out.println(odd_index);

        for (long l : even) {
            System.out.print(l + " ");
        }
        System.out.println();
        for (long l : odd) {
            System.out.print(l + " ");
        }
        System.out.println();
        System.out.println("After sort");

        sort(0, even_index - 1, even);
        sort(0, odd_index - 1, odd);

        for (long l : even) {
            System.out.print(l + " ");
        }
        System.out.println();
        for (long l : odd) {
            System.out.print(l + " ");
        }
        System.out.println();
        System.out.println("Output");

        int odd_len = odd_index - 1;
        int event_len = 0;

        while (event_len < even_index && odd_len >= 0) {
            System.out.print(odd[odd_len] + " ");
            System.out.print(even[event_len] + " ");
            odd_len--;
            event_len++;
        }

        while (odd_len >= 0) {
            System.out.print(odd[odd_len] + " ");
            odd_len--;
        }
        while (event_len < even.length) {
            System.out.print(even[event_len] + " ");
            event_len++;
        }


    }

    public static void sort(int low, int high, long[] arr) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid, arr);
            sort(mid + 1, high, arr);
            merge(low, mid, high, arr);
        }
    }

    public static void merge(int low, int mid, int high, long[] arr) {
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
            i++;
            k++;
        }
        while (j < l2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
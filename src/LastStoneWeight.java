//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }
        int n = stones.length;

        int i = n - 2, j = n - 1;
        sort(0, n - 1, stones);
        for (int x : stones)
        {
            System.out.print(x+" ");
        }
        System.out.println();

        while (stones[i] != 0) {
            if (stones[i] == stones[j]) {
                stones[i] = 0;
                stones[j] = 0;
            } else if (stones[i] < stones[j]) {
                stones[j] -= stones[i];
                stones[i] = 0;
            }
            sort(0, n - 1, stones);

            for (int x : stones)
            {
                System.out.print(x+" ");
            }
            System.out.println();
        }

        return stones[j];
    }

    public static void sort(int left, int right, int[] arr) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(left, mid, arr);
            sort(mid + 1, right, arr);
            merge(left, mid, right, arr);
        }
    }

    public static void merge(int left, int mid, int right, int[] arr) {
        int l1 = mid - left + 1;
        int l2 = right - mid;

        int[] L = new int[l1];
        int[] R = new int[l2];

        for (int i = 0; i < l1; i++) {
            L[i] = arr[i + left];
        }
        for (int i = 0; i < l2; i++) {
            R[i] = arr[i + mid + 1];
        }

        int i = 0, j = 0, k = left;

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
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

}

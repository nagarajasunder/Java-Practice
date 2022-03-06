public class FindTheMissingNumberInArray {

    public static void main(String[] args) {
        System.out.println(MissingNumber1(new int[]{1, 2, 3, 5}, 5));
        System.out.println(MissingNumber2(new int[]{1, 2, 3, 5}, 5));
    }

    public static int MissingNumber1(int array[], int n) {
        int sum = (n * (n + 1)) / 2;
        for (int i = 0; i < n - 1; i++) {
            sum -= array[i];
        }

        return sum;
    }

    public static int MissingNumber2(int arr[], int n) {
        int x1 = arr[0];
        int x2 = 1;

        for (int i = 1; i < n-1; i++) {
            x1 ^= arr[i];
        }
        for (int i = 2;i<n+1;i++)
        {
            x2^=i;
        }
        return (x1^x2);
    }

}

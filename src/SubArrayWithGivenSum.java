import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the text");
        String str[] = s.nextLine().split(" ");

        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }


        System.out.println(subArraySum(arr, arr.length, 12));

    }

    static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();

        int left = 0, right = 0, currentSum = 0;
        while (left <= right) {
            if (currentSum == s) {
                list.add(left + 1);
                list.add(right);
                return list;
            }
            if (currentSum < s) {
                currentSum += arr[right];
                right++;
            }
            if (currentSum > s) {
                currentSum -= arr[left];
                left++;
            }
        }

        list.add(-1);
        return list;
    }
}

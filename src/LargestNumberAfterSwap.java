import java.util.Collections;
import java.util.PriorityQueue;


public class LargestNumberAfterSwap {

    public static void main(String[] args)
    {
        System.out.println(largestInteger(1234));
    }

    public static int largestInteger(int num) {

        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        char[] arr = String.valueOf(num).toCharArray();

        for (char value : arr) {
            int digit = value - '0';

            if (digit % 2 == 0) {
                even.add(digit);
            } else {
                odd.add(digit);
            }
        }

        System.out.println(even);
        System.out.println(odd);
        int ans = 0;

        for (int c : arr) {
            ans *= 10;
            ans += c % 2 == 0 ? even.poll() : odd.poll();
        }

        return ans;


    }
}


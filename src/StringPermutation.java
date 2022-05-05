public class StringPermutation {

    public static void main(String[] args) {

        String str = "123";

        permutate(str, 0, str.length() - 1);
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }

    public static void permutate(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, i, l);
                permutate(str, l + 1, r);
                str = swap(str, l, i);
            }
        }


    }

    public static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);

    }

}

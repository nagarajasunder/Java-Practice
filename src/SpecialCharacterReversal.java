class SpecialCharactersReversal {
    public static void main(String[] args) {
        String s = "Hello world";
        String[] arr = s.split(" ");

        System.out.println(recurseReverse(s, s.length() - 1));
        System.out.println(reverse(arr.length - 1, arr));

    }

    static String reverse(int n, String[] arr) {
        if (n < 0) {
            return "";
        } else {
            return recurseReverse(arr[n], arr[n].length() - 1) + " " + reverse(n - 1, arr);
        }

    }

    static String recurseReverse(String s, int n) {
        if (n < 0) {
            return "";
        }
        return s.charAt(n) + recurseReverse(s, n - 1);
    }


}
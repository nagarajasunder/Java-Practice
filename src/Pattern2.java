public class Pattern2 {

    public static void main(String[] args) {
        int n = 4;
        StringBuilder result = new StringBuilder("0");
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }

            if (i > 0) {
                result = new StringBuilder(i + result.toString() + i);
            }
            System.out.println(result);
        }
    }
}

import java.util.Arrays;

public class Urlify {

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int l = 13;
        System.out.println(urlify(s,l-1));
    }

    private static String urlify(String s, int length) {

        char[] result = s.toCharArray();
        int result_len = result.length - 1;


        while (length >= 0) {
            if (s.charAt(length) != ' ') {
                result[result_len--] = s.charAt(length);
            } else {
                result[result_len--] = '0';
                result[result_len--] = '2';
                result[result_len--] = '%';
            }
//            System.out.println(Arrays.toString(result));
            length--;
        }

        return String.valueOf(result);

    }

}

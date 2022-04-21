public class RunLengthEncoding {

    public static void main(String[] args) {
        var str = encode("bbbccccccddddddddddddddd");
        System.out.println(str);
        System.out.println(decode(str));
    }

    static String decode(String str) {
        int ct = 0;
        char char_to_repeat = 0;
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < str.length()) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (ct > 0) {
                    result.append(String.valueOf(char_to_repeat).repeat(ct));
                }
                char_to_repeat = str.charAt(i);
                ct = 0;
            } else {
                ct = ct * 10 + Character.getNumericValue(str.charAt(i));
            }
            i++;
        }

        if (ct > 0) {
            result.append(String.valueOf(char_to_repeat).repeat(ct));
        }

        return result.toString();

    }

    static String encode(String str) {

        StringBuilder s = new StringBuilder();


        int i = 1;
        int ct = 1;
        char checker = str.charAt(0);

        while (i < str.length()) {
            if (str.charAt(i) == checker) {
                ct++;
            } else {
                s.append(checker);
                s.append(ct);
                ct = 1;
                checker = str.charAt(i);
            }
            i++;
        }

        s.append(checker);
        s.append(ct);

        return s.toString();
    }

}

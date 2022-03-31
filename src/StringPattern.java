import java.util.Objects;

public class StringPattern {

    public static void main(String[] args) {

        System.out.println(strStr("aaaaa","bba"));
    }

    public static int strStr(String haystack, String needle) {

        if (Objects.equals(needle, "")) {
            return 0;
        }
        if (Objects.equals(haystack, "") || needle.length() > haystack.length()) {
            return -1;
        }

        int i = 0, j = 0;
        String temp = "";

        while (i < haystack.length()) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (j - i + 1 <= needle.length()) {
                    temp += haystack.charAt(j);
                } else if (temp.equals(needle)) {
                    return i;
                } else {
                    temp = "";
                    i++;
                    j = i - 1;
                }
            } else {
                i++;
            }
            j++;
        }
        return -1;

    }

}

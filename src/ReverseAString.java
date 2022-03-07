public class ReverseAString {

    public static void main() {
        reverseWord("Hello");
    }

    public static String reverseWord(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
}

public class BackSpaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        return removeBackSpace(s).equals(removeBackSpace(t));
    }

    public static String removeBackSpace(String str) {
        StringBuilder ns = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                ns.append(c);
            } else if (ns.length() > 0) {
                ns.deleteCharAt(ns.length() - 1);
            }
        }
        return ns.toString();
    }
}

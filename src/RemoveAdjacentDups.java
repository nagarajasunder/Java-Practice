//import kotlin.Pair;
//
//import java.util.Stack;
//
//public class RemoveAdjacentDups {
//
//    public static void main(String[] args) {
//        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
//    }
//
////    public static String removeDuplicates(String s, int k) {
////
////        int len = s.length();
////
////        if (len < k) {
////            return s;
////        }
////
////        int i = 0;
////        int j = 1;
////
////        while (j < len && len >= k) {
////            if (s.charAt(i) == s.charAt(j)) {
////                if ((j - i + 1) == k) {
////                    StringBuilder new_str = new StringBuilder();
////                    new_str.append(s, 0, i);
////                    if (j + 1 < len) {
////                        new_str.append(s.substring(j + 1));
////                    }
////                    len = new_str.length();
////                    s = new_str.toString();
////                    i = 0;
////                    j = 1;
////                }
////                else
////                {
////                    j++;
////                }
////            } else {
////                i = j;
////                j++;
////            }
////
////
////        }
////
////        return s;
////    }
//
//
//    public static String removeDuplicates(String s, int k) {
//
//        Stack<int[]> master = new Stack<>();
//
//        for (char c : s.toCharArray()) {
//            if (!master.isEmpty() && master.peek()[0] == c) {
//                master.peek()[1]++;
//            } else {
//                master.push(new int[]{c, 1});
//            }
//            if (master.peek()[1] == k) {
//                master.pop();
//            }
//        }
//
//        while (!master.isEmpty()) {
//            int top[] = master.pop();
//            while (top[1]-- > 0)
//                sb.append((char) top[0]);
//        }
//
//    }
//
//
//}

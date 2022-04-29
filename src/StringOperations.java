import java.util.List;

public class StringOperations {

    public static void main(String[] args) {
        String s = "12345*+-+";

       String x = "-1-2";
       for (int i = 0;i<x.length();i++)
       {
           System.out.println(Character.getNumericValue(x.charAt(i)));
       }

//        StringBuilder numbers = new StringBuilder();
//
//        int i = 0;
//
//        while (Character.getNumericValue(s.charAt(i)) >= 0) {
//            numbers.append(s.charAt(i));
//            i++;
//        }
//
//        int result = Character.getNumericValue(numbers.charAt(0));
//
//        int j = 1;
//
//        while (j < numbers.length()) {
//            switch (s.charAt(i)) {
//                case '+' -> result = result + Character.getNumericValue(numbers.charAt(j));
//                case '-' -> result = result - Character.getNumericValue(numbers.charAt(j));
//                case '*' -> result = result * Character.getNumericValue(numbers.charAt(j));
//                case '/' -> result = result / Character.getNumericValue(numbers.charAt(j));
//            }
//            i++;
//            j++;
//        }
//
//        System.out.println(result);

    }

}

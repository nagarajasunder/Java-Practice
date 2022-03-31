//Problem link https://leetcode.com/problems/plus-one/

public class PlusOne {

    //Not Optimized solution
    //    public static int[] plusOne(int[] digits) {
//
////        long sum = 0, multiply = 1;
//
//        BigInteger sum = new BigInteger("0");
//        BigInteger multiply = new BigInteger("1");
//
//
//        for (int i = digits.length - 1; i >= 0 && multiply.subtract(sum).equals(new BigInteger("1")); i--) {
//            sum = sum.add(multiply.multiply(BigInteger.valueOf(digits[i])));
//            multiply = multiply.multiply(BigInteger.valueOf(10));
//        }
//
//        BigInteger plus = new BigInteger("0");
//        plus = plus.add(sum);
//        plus = plus.add(BigInteger.valueOf(1));
//        System.out.println("Sum " + sum + " Plus " + plus);
//        int[] plusOne = new int[(digits.length - String.valueOf(sum).length()) + String.valueOf(plus).length()];
//
//        int i = 0;
//        while (i < digits.length - String.valueOf(sum).length()) {
//            plusOne[i] = digits[i];
//            i++;
//        }
//        for (int j = plusOne.length - 1; j >= i; j--) {
//            multiply = plus.mod(BigInteger.valueOf(10));
//            plusOne[j] = multiply.intValue();
//            plus = plus.divide(BigInteger.valueOf(10));
//        }
//
//        return plusOne;
//    }

    //Optimized Solution
    public static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }

        int[] plusOne = new int[arr.length + 1];
        plusOne[0] = 1;
        return plusOne;
    }

}

//problem link https://leetcode.com/problems/add-binary/
public class addBinaryStrings {


    public static void addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        String output = "";

        while (i >= 0 || j >= 0) {

            char c_i = i < 0 ? '0' : a.charAt(i);
            char c_j = j < 0 ? '0' : b.charAt(j);

            if (c_i == c_j) {

                if (c_i == '1') {
                    if (carry == 0) {
                        output = 0 + output;
                        carry = 1;
                    } else {
                        output = 1 + output;
                    }
                } else if (c_i == '0') {
                    if (carry == 0) {
                        output = 0 + output;
                    } else {
                        output = 1 + output;
                        carry = 0;
                    }
                }

            } else if (c_i == '1' || c_j == '1') {
                if (carry == 0) {
                    output = 1 + output;
                } else {
                    output = 0 + output;
                }
            }


            System.out.println("For i " + c_i + " j " + c_j + " output " + output);

            i--;
            j--;
        }

        if (carry == 1) {
            output = "1" + output;
        }

        System.out.println(output);

    }


}



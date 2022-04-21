public class Pattern1 {

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";

        int i_ct = 0;
        int j_ct = str.length() - 1;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (j == i_ct || j == j_ct) {
                    System.out.print(str.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            i_ct++;
            j_ct--;
        }


    }
}

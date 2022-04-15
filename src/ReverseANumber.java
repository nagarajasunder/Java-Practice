public class ReverseANumber {


    public static void main(String[] args) {
        int n = -19;
        int reverse = 0;
        while (n != 0) {
            int reminder = n % 10;
            reverse = reverse * 10 + reminder;
            n /= 10;
        }

        System.out.println(reverse);
    }

}

import java.util.Scanner;

public class ChefDiet {

        public static void main(String[] args) {

            try {
                Scanner s = new Scanner(System.in);
                int tc = s.nextInt();
                for (int i = 0; i < tc; i++) {
                    boolean proteinDeficit = false;
                    int balance = 0;
                    int n = s.nextInt();
                    int k = s.nextInt();

                    int[] arr = new int[n];

                    for (int j = 0; j < n; j++) {
                        arr[j] = s.nextInt();
                    }

                    for (int j = 0; j < n; j++) {
                        if (k > (arr[j] + balance)) {
                            System.out.println("NO " + (j + 1));
                            proteinDeficit = true;
                            break;
                        } else {
                            balance = (balance + arr[j]) - k;
                        }
                    }

                    if (!proteinDeficit) {
                        System.out.println("YES");
                    }

                }


            } catch (Exception e) {
                return;
            }

        }
}


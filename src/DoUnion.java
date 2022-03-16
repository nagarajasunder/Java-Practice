import java.util.ArrayList;
import java.util.Scanner;

public class DoUnion {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the text");
        String[] str = s.nextLine().split(" ");

        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println("Enter the text");
        String[] str1 = s.nextLine().split(" ");

        int[] arr1 = new int[str1.length];

        for (int i = 0; i < str1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }

        System.out.println(doUnion(arr, arr.length, arr1, arr1.length));
    }

    public static int doUnion(int a[], int n, int b[], int m) {
        ArrayList<Integer> map = new ArrayList<>();

        int i = 0,j = 0;
        while (i < n && j < m)
        {
            if (a[i] == b[j])
            {
                map.add(a[i]);
            }
            else
            {
                map.add(a[i]);
                map.add(b[j]);
            }
            i++;
            j++;
        }

        while (i<n)
        {
            map.add(a[i]);
            i++;
        }

        while (j<m)
        {
            map.add(b[j]);
            j++;
        }


        return map.size();
    }

}

import java.util.ArrayList;
import java.util.List;

public class MergeArrayWithoutDuplicates {



    public static void main(String[] args) {
        int[] a1 = new int[]{2, 4, 5, 6, 7, 9, 10, 13};
        int[] a2 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11, 15};

        System.out.println(merge(a1,a2));
    }

    static List<Integer> merge(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        int i_len = arr1.length;
        int j_len = arr2.length;
        int last_added_element = Integer.MAX_VALUE;

        while (i < i_len && j < j_len) {
            if (arr1[i] <= arr2[j]) {
                if (arr1[i] != last_added_element) {
                    result.add(arr1[i]);
                    last_added_element = arr1[i];
                }
                i++;
            } else {
                if (arr2[j] != last_added_element) {
                    result.add(arr2[j]);
                    last_added_element = arr2[j];
                }
                j++;
            }
        }

        while (i < i_len) {
            if (arr1[i] != last_added_element) {
                result.add(arr1[i]);
                last_added_element = arr1[i];
                i++;
            }
        }
        while (j < j_len) {
            if (arr2[j] != last_added_element) {
                result.add(arr2[j]);
                last_added_element = arr2[j];
                j++;
            }
        }


        return result;
    }

}

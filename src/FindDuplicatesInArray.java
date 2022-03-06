import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        System.out.println(duplicates(new int[]{13, 9, 25, 1, 1, 0, 22, 13, 22, 20, 3, 8, 11, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25, 14, 23, 14}, 26));
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                if (map.get(arr[i]) == 2) {
                    list.add(arr[i]);
                }
            } else {
                map.put(arr[i], 1);
            }
        }
        if (list.size() == 0) {
            list.add(-1);
        }
        Collections.sort(list);
        return list;
    }

}


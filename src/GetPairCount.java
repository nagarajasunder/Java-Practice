import java.util.HashMap;

public class GetPairCount {

    public static void main(String[] args) {
        System.out.println(getPairsCount(new int[]{1, 5, 7, 1,}, 4, 6));
    }

    public static int getPairsCount(int[] arr, int n, int k) {

        int ct = 0;
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) {
                ct += map.get(k - arr[i]);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        return ct;

    }

}

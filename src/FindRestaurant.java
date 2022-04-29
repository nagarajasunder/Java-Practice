import java.util.HashMap;

public class FindRestaurant {

    public static void main(String[] args) {
        findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap();
        int minIndex = Integer.MAX_VALUE;
        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }


        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                System.out.println(list2[i] + " " + map.get(list2[i]));
                int index = map.get(list2[i]) + i;
                if (index < minIndexSum) {
                    minIndexSum = index;
                    minIndex = i;
                }
            }
        }

        String[] result = new String[1];
        System.out.println(minIndex);
        result[0] = list2[minIndex];

        return result;
    }
}

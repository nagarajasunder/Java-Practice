import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

        public static List<List<Integer>> generate(int numRows) {

            List<List<Integer>> pascal = new ArrayList();

            pascal.add(new ArrayList<>());
            pascal.get(0).add(1);

            int it = 1;

            while (it < numRows) {
                List<Integer> new_list = new ArrayList();
                new_list.add(1);

                List<Integer> old_list = pascal.get(it - 1);

                int left = 0, right = 1;

                for (int i = 1; i < it; i++) {
                    new_list.add(old_list.get(left) + old_list.get(right));
                    left++;
                    right++;
                }
                new_list.add(1);
                pascal.add(new_list);
                it++;
            }

            return pascal;
        }

        public static void main(String[] args) {
            System.out.println(generate(5));
        }

}

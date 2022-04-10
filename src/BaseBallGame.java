import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    public static int calPoints(String[] ops) {

        List<Integer> list = new ArrayList();
        int currentSize = -1;
        int sum = 0;

        for (String op : ops) {

            if (op.charAt(0) >= 'A' && op.charAt(0) <= 'Z') {
                if (op.charAt(0) == 'C') {
                    int remove_point = list.get(currentSize);
                    list.remove(currentSize);
                    sum -= remove_point;
                    currentSize--;
                } else {
                    int new_point = list.get(currentSize)*2;
                    list.add(new_point);
                    sum+=new_point;
                    currentSize++;
                }
            } else if (op.charAt(0) == '+') {
                int new_point = list.get(currentSize) + list.get(currentSize - 1);
                list.add(new_point);
                sum += new_point;
                currentSize++;
            } else {

                int new_point = Integer.parseInt(op);
                list.add(new_point);
                sum += new_point;
                currentSize++;
            }
        }


        return sum;
    }

}

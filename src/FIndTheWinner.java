import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FIndTheWinner {

    public static void main(String[] args) {
//        System.out.println(findTheWinner(6,5));

//        long pastHour = System.currentTimeMillis() - (3600 * 1000);
//        long currentTime = System.currentTimeMillis();
//        long orderedTime = 1651389716260L;
//        System.out.println("Past hour " + pastHour + " Current time " + currentTime + " Ordered time " + orderedTime);
//        System.out.println("Past hour " + DateFormat.getDateTimeInstance().format(pastHour) + " Current time " + DateFormat.getDateTimeInstance().format(currentTime) + " Ordered time " + DateFormat.getDateTimeInstance().format(orderedTime));
//        System.out.println(orderedTime >= pastHour && orderedTime <= currentTime);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, -7);
        System.out.println(cal.getTime());
    }

    public static int findTheWinner(int n, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return helper(list, k, 0);

    }

    public static int helper(List<Integer> list, int k, int curr) {
        if (list.size() == 1) {
            return list.get(0);
        }

        curr = (curr + k - 1) % list.size();
        System.out.println("Current " + curr);
        list.remove(curr);
        System.out.println(list);

        return helper(list, k, curr);
    }

}

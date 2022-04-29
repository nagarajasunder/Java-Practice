import java.util.ArrayList;
import java.util.Arrays;

public class MoreProfit {

    public static void main(String[] args) {

        int[] difficulty = new int[]{68, 35, 52, 47, 86};
        int[] profit = new int[]{67, 17, 1, 81, 3};
        int[] worker = new int[]{92, 10, 85, 84, 82};

        int maxProfit = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(maxProfit);

    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        bubbleSort(difficulty,profit);
        int profitSum = 0;
//        for (int j : worker) {
//            int currentWorkIndex = getMyWork(0, difficulty.length - 1, difficulty, j, profit);
//            System.out.println("Current work index " + currentWorkIndex);
//            if (currentWorkIndex != -1) {
//                profitSum += profit[currentWorkIndex];
//            }
//        }

        return profitSum;
    }

    private static void bubbleSort(int[] difficulty, int[] profit) {

        for(int i = 0;i<difficulty.length-1;i++)
        {
            for (int j = 0;j<difficulty.length-1-i;j++)
            {
                if (difficulty[j] > difficulty[j+1])
                {
                    int temp = difficulty[j];
                    difficulty[j] = difficulty[j+1];
                    difficulty[j+1] = temp;

                    temp = profit[j];
                    profit[j] = profit[j+1];
                    profit[j+1] = temp;
                }
            }
        }




    }



    public static int getMyWork(int low, int high, int[] difficulty, int ability, int[] profit) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (difficulty[mid] <= ability) {
                int moreDifficulty = getMyWork(mid + 1, high, difficulty, ability, profit);
                if (moreDifficulty != -1) {
                    if (difficulty[moreDifficulty] > difficulty[mid]) {
                        return moreDifficulty;
                    }
                }
                return mid;
            } else {
                return getMyWork(low, mid - 1, difficulty, ability, profit);
            }
        }
        return -1;
    }

}

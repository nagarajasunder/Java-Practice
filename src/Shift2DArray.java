import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DArray {
    //    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int total = m * n;
//
//        for (int i = 0; i < m; i++) {
//            List<Integer> subList = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                int index = (((i * n) + j) + k) % total;
//                System.out.println("For i " + i + " j " + j + " index " + index + " indices (" + (index / n) + "," + (index % n) + ")");
//                subList.add(grid[index / n][index % n]);
//            }
//            list.add(subList);
//        }
//        return list;
//
//    }
    //Another Method
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int R = grid.length;
        int C = grid[0].length;

        //IF k = 5 and m*n is if also 5 then the result will be same as the provided grid. So we are taking mod to remove the unwanted loops
        int mod = k % (R * C);

        if (mod == 0) {
            return getRotatedForm(grid, 0, 0);
        }

        int target = (R * C) - mod;
        int r, c;
        //This If else gives me the first element that i have to add in the list
        if (C == 1) {
            c = 0;
            r = target;
        } else {
            r = target / C;
            c = target % C;
        }

        return getRotatedForm(grid, r, c);

    }


    public static List<List<Integer>> getRotatedForm(int[][] grid, int i, int j) {
        List<List<Integer>> result = new ArrayList<>();

        int rLen = grid.length;
        int cLen = grid[0].length;

        for (int l = 0; l < rLen; l++) {
            List<Integer> row = new ArrayList<>();
            for (int m = 0; m < cLen; m++) {
                row.add(i, j);
                if (j == cLen - 1) {
                    j = 0;
                    i = i == rLen - 1 ? 0 : (i + 1);
                } else {
                    j++;
                }
            }
            result.add(row);
        }

        return result;

    }


    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> list = shiftGrid(arr, 1);
        System.out.println(list);


    }
}
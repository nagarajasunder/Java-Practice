import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//class Solution {
//    public static void setZeroes(int[][] matrix) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][j] = -1;
//                }
//            }
//        }
//
//        System.out.println("Temp Version");
//        for (int[] ints : matrix) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(ints[j]);
//            }
//            System.out.println();
//        }
//        System.out.println("Final Version");
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == -1) {
//                    makeRowsZero(matrix, i,j, cols);
//                    makeColumnsZero(matrix, rows,i, j);
//                }
//            }
//        }
//
////        System.out.println(map.size());
////        for (var mapElement : map.entrySet()) {
////            int row = mapElement.getKey();
////            int col = mapElement.getValue();
////            System.out.println("(Row,Column) = ("+row+","+col+")");
////            makeRowsZero(matrix, row, cols);
////            makeColumnsZero(matrix, rows, col);
////        }
//
//        for (int[] ints : matrix) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(ints[j]);
//            }
//            System.out.println();
//        }
//    }
//
//    public static void makeColumnsZero(int[][] matrix, int rows, int current_row, int col) {
//        for (int i = 0; i < rows; i++) {
//            if (matrix[i][col] == -1) {
//                if (i == current_row) {
//                    matrix[i][col] = 0;
//                }
//            } else {
//                matrix[i][col] = 0;
//            }
//        }
//
//    }
//
//    public static void makeRowsZero(int[][] matrix, int row, int current_col, int colCt) {
//        for (int i = 0; i < colCt; i++) {
//            if (matrix[row][i] != -1) {
//                if (i == current_col) {
//                    matrix[row][i] = 0;
//                }
//            } else {
//                matrix[row][i] = 0;
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        var x = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        for (int[] ints : x) {
//            for (int j = 0; j < x[0].length; j++) {
//                System.out.print(ints[j]);
//            }
//            System.out.println();
//        }
//        setZeroes(x);
//
//    }
//}
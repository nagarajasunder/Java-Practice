public class SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {

        int[][] arr = new int[n][n];

        int ct = 1;

        for (int layer = 0; layer < (n + 1) / 2; layer++) {

            //Left To Right
            for (int i = layer; i < n - layer; i++) {
                arr[layer][i] = ct++;
            }

//          //Top to Bottom
            for (int i = layer + 1; i < n - layer; i++) {
                arr[i][n - layer - 1] = ct++;
            }

//            //Right to Left
            for (int i = n - layer - 2; i >= layer; i--) {
                arr[n - layer - 1][i] = ct++;
            }
            //Bottom to Top
            for (int i = n - layer - 2; i >= layer + 1; i--) {
                arr[i][layer] = ct++;
            }

        }

        return arr;
    }
}

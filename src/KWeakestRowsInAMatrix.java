public class KWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] war = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        kWeakestRows(war, 3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {


        int rows = mat.length;
        int columns = mat[0].length;

        int[] soldiers = new int[rows];
        int[] indices = new int[rows];

        for (int i = 0; i < rows; i++) {
            int soldierCt = 0;
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 0) {
                    break;
                } else {
                    soldierCt++;
                }
            }
            soldiers[i] = soldierCt;
            indices[i] = i;
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (soldiers[j] > soldiers[j+1]) {
                    int temp = soldiers[j];
                    soldiers[j] = soldiers[j+1];
                    soldiers[j+1] = temp;

                    temp = indices[j];
                    indices[j] = indices[j+1];
                    indices[j+1] = temp;
                }
            }
        }

        for (int i : indices)
        {
            System.out.print(i+" ");
        }

        int[] result = new int[k];
        System.arraycopy(indices, 0, result, 0, k);



        return result;
    }
}

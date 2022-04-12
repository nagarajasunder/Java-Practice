
public class GameOfLife {
    public static  int[][] DIRS = new int[][]{
        {-1,-1},
        {-1,0},
        {-1,1},
        {0,-1},
        {0,1},
        {1,-1},
        {1,0},
        {1,1}
    };

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;



        playGame(board,rows,cols);
        updateBoard(board,rows,cols);

    }

    public static void updateBoard(int[][] board,int rows,int cols)
    {
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                board[i][j] >>=1;
            }
        }
    }


    public static void playGame(int[][] board,int rows,int cols)
    {


        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                int alive = getAliveNeighbours(board,i,j,rows,cols);

                if(board[i][j] == 1 && (alive == 2 || alive == 3))
                {
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && alive == 3)
                {
                    board[i][j] = 2;
                }

            }
        }
    }

    public static int getAliveNeighbours(int[][] board , int row, int col , int rows , int cols)
    {
        int alive = 0;
        for(var dir : DIRS)
        {
            int neighbourX = row+dir[0];
            int neighbourY = col+dir[1];

            if(outOfBounds(neighbourX,neighbourY,rows,cols))
                continue;
            alive+= board[neighbourX][neighbourY] & 1;

        }
        return alive;
    }

    public static boolean outOfBounds(int neighbourX,int neighbourY,int rows,int cols)
    {
        return neighbourX < 0 || neighbourY < 0 || neighbourX >= rows || neighbourY >= cols;
    }
}
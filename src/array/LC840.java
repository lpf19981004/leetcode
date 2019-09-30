package array;

/**
 * @author liangpf
 * @Date 2019/9/30
 */
public class LC840 {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                cnt += judge(grid, i, j);
            }
        }


        return cnt;
    }

    private int judge(int[][] grid, int row, int col) {
        int rowSum = 0;
        int cloSum = 0;
        for (int i = row; i < row + 3; i++) {
            int temp = grid[i][cloSum];
            for (int j = col; j < col + 3; j++) {

            }
        }

        return 0;
    }
}

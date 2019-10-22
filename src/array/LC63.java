package array;

/**
 * @author liangpf
 * @date 2019/10/14
 */
public class LC63 {


    public static void main(String[] args) {
        LC63 demo = new LC63();
        int res = demo.uniquePathsWithObstacles(new int[][]{{0, 0, 0}});
        System.out.println(res);
    }

    private int[][] temp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        temp = new int[m][n];
        return findPath(0, 0, m, n, obstacleGrid);
    }

    private int findPath(int x, int y, int m, int n, int[][] flag) {
        if (flag[x][y] == 1) return 0;
        // 判断最后的位置是否可达
        if (x == m - 1 && y == n - 1) return 1;
        // 如果走到了终点返回1
        int res = 0;
        // 查询之前走过的路径
        if (temp[x][y] != 0) {
            return temp[x][y];
        }
        // 走到了最右端,只能往下边走
        if (y == n - 1 && flag[x + 1][y] == 0) {
            res += findPath(x + 1, y, m, n, flag);
        } else if (x == m - 1 && flag[x][y + 1] == 0) { // 走到了最下边，只能往右边走
            res += findPath(x, y + 1, m, n, flag);
        } else {
            // 两边的可能性
            if (x < m && y < n - 1 && flag[x][y + 1] == 0)
                res += findPath(x, y + 1, m, n, flag);
            if (x < m - 1 && y < n && flag[x + 1][y] == 0)
                res += findPath(x + 1, y, m, n, flag);
        }
        // 记忆走的路径
        if (res > 0) {
            temp[x][y] = res;
        }
        return res;
    }

    /**
     * 动态规划解法
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // 一共有多少行
        int R = obstacleGrid.length;
        // 一共有多少列
        int C = obstacleGrid[0].length;
        // 检查第一个格子是否是障碍物的情况，如果是第一个就是障碍物，则必然无法到达终点，返回0
        // 最后一个格子是障碍物，则始终无法到达终点
        if (obstacleGrid[0][0] == 1 || obstacleGrid[R-1][C-1] == 1) {
            return 0;
        }
        // 如果上一步没有返回0，设置到达第一个格子的方案个数为1，有且只有1步走法到达第一个格子
        obstacleGrid[0][0] = 1;
        // 填充第一列的步数，如果没有障碍物，则将格子置为1，如果有障碍物，则置为0
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        // 填充第一行，如果在向右走的过程中，发现障碍物则置为0，否则置为1
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        // 因为机器人只能向右走或者向下走
        // 所以某一个位置的格子一定是机器人从上边一个格子走下来的或者是从左边的格子走过来的
        // 到达这个格子的所有可能就是左边前一个格子和上边的格子的所有可能之和
        // 如果这个格子是障碍物，则将格子直接置为0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        // 返回到达终点的所有可能
        return obstacleGrid[R - 1][C - 1];
    }
}

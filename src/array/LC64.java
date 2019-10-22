package array;

import java.util.Arrays;

/**
 * @author liangpf
 * @date 2019/10/14
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 1 3 4 5
 * 2 8 1 6
 * 6 1 1
 */
public class LC64 {

    public static void main(String[] args) {
        LC64 demo = new LC64();
        int res = demo.minPathSum(new int[][]{{1, 3,1}, {1, 5,1},{4,2,1}});
        System.out.println(res);
    }


    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                ans += grid[0][i];
            }
            return ans;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                ans += grid[i][0];
            }
            return ans;
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int j = 1; j < m; j++) {
            grid[j][0] += grid[j-1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = (Math.min(grid[i][j]+grid[i - 1][j], grid[i][j]+grid[i][j - 1]));
            }
        }
        return grid[m-1][n-1];
    }
}
